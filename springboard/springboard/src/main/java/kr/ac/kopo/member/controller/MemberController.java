package kr.ac.kopo.member.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.LoginVO;
import kr.ac.kopo.member.vo.MemberVO;


@Controller
@SessionAttributes("currentUser")
public class MemberController {

    @Autowired
    private MemberService memberService;
    
    @GetMapping("/login")
    public String loginForm(Model model) {
        LoginVO loginVO = new LoginVO();
        model.addAttribute(loginVO);
        return "member/loginForm";
    }

    @PostMapping("/login")
    public String loginProcess(@Valid LoginVO loginVO, Errors errors, Model model, HttpSession session) {
        if (errors.hasErrors()) { // error가 존재시에 다시 로그인 페이지로 이동
            return "member/loginForm";

        } else {
            MemberVO memberVO = memberService.login(loginVO);
            if (memberVO == null) { // id와 password가 틀린경우, 사용자 없음,
                System.err.println("id/password가 틀렸습니다.");
                model.addAttribute("msg", "id와 password를 다시 확인하세요.");
                return "member/loginForm"; // 다시 로그인 하는 페이지로 이동
            }
            System.out.println("Login이 완료되었습니다. ");
            System.out.println(memberVO);

            /*
             * // session에 등록, jsp에서 ${currentUser} 를 통해 접근 가능 hong/1111 => memberVO
             * session.setAttribute("currentUser", memberVO);
             */
            
            model.addAttribute("currentUser", memberVO);
            //*************************************
            //수정 필요. redirect 주소 수정 필요
            //**************************************
            
            String dest = (String) session.getAttribute("dest");
            session.removeAttribute("dest");
            if(dest == null) {  //제대로 로그인페이지를 먼저 들어갔을 경우 (인터셉터를 거치지 않은 경우) 
                return "redirect:/";
            } else {  //dest가 있으면,로그인을 안해서 interceptor가 잡아와서 생긴 dest 세션이다.
                return "redirect:"+dest;
            }
            
         
            
        } // error가 존재하지 않을 때, 정상 시나리오

    }
       
    //@GetMapping("/logout")
    public String logout(HttpSession session) {
        //session.removeAttribute("currentUser");
        session.invalidate();  //setAttribute 로 만든 세션은 이렇게 지운다 
        
        return "redirect:/";
    }
    
    @GetMapping("/logout")
    public String logout2(SessionStatus sessionStatus) {
        //session.invalidate();
        sessionStatus.setComplete();
        return "redirect:/";
    }

    

    @GetMapping("/join")
    public String joinForm(Model model) {
        MemberVO memberVO = new MemberVO();
        model.addAttribute(memberVO);
        return "member/joinForm";
    }

    @PostMapping("/join")
    public String joinProcess(@Valid MemberVO memberVO, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("msg", "입력하지 않은 값이 존재합니다.");
            return "member/joinForm";
        } else {
            memberService.join(memberVO);
            model.addAttribute(memberVO);
            return "redirect:/board";
        }
    }

}