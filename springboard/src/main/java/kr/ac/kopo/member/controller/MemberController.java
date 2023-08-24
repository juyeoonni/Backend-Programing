package kr.ac.kopo.member.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.LoginVO;
import kr.ac.kopo.member.vo.MemberVO;

@Controller
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
    public String loginProcess(@Valid LoginVO loginVO, Errors errors, Model model) {
        if (errors.hasErrors()) { // error가 존재시에 다시 로그인 페이지로 이동            
            return "member/loginForm";

        } else {
            MemberVO memberVO = memberService.login(loginVO);
            if(memberVO==null) {  //id와 password가 틀린경우, 사용자 없음, 
                System.err.println("id/password가 틀렸습니다.");
                model.addAttribute("msg", "id와 password를 다시 확인하세요.");
                return "member/loginForm";  //다시 로그인 하는 페이지로 이동 
            }
            System.out.println("Login이 완료되었습니다. ");
            System.out.println(memberVO);
            return "redirect:/board";
        } // 존재하지 않을 때

    }
}
