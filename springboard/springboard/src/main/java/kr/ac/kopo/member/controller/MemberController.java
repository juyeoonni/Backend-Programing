package kr.ac.kopo.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.LoginVO;
import kr.ac.kopo.member.vo.MemberVO;

@SessionAttributes("currentUser")
@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	
	@GetMapping("/logout")
	public String logout2( SessionStatus sessionStatus, HttpSession session ) { 
		session.invalidate();   //setAttributes ->dest
		sessionStatus.setComplete();   //@SessionAttributes 등록되어 있는 변수들
										//currentUser
		
		return "redirect:/";  
	}
	
	//@GetMapping("/logout")
	public String logout(HttpSession session) {
		//session.setAttribute("currentUser", memberVO);
		//session.removeAttribute("currentUser");
		session.invalidate();
		//"index"    WEB-INF/jsp/index.jsp (x)
		//webapp/index.jsp 
		//http://localhost:8080/springboard/
		return "redirect:/";
	}
	
	
	@GetMapping("/login")
	public String loginForm(Model model) {
		LoginVO loginVO = new LoginVO();
		model.addAttribute(loginVO);
		return "member/loginForm";
		//member/loginForm.jsp
	}
	@PostMapping("/login")
	public String loginProcess(@Valid LoginVO loginVO, 
								Errors errors, 
								Model model,
								HttpServletRequest request,
								HttpSession session) {  		
		if(errors.hasErrors()) { // error가 존재, null값이 존재. 다시 쓰세요
			return "member/loginForm";   //다시 로그인 하는 페이지로 이동
		}else {				//null값이 없을때, DB query 실행
			MemberVO memberVO = memberService.login(loginVO);
			if(memberVO == null) { //id와 password 틀린경우, 사용자 없음, 
				System.err.println("id/password가 틀렸습니다. ");
				model.addAttribute("msg","id와 password를 다시 확인하세요.");
				return "member/loginForm";   //다시 로그인 하는 페이지로 이동
			}else {				
				System.out.println("login이 완료되었습니다."+ memberVO); 
				//session등록 , jsp ${currentUser}  hong/1111 -> memberVO
				//1) session.setAttribute("currentUser", memberVO);
				//2) @sessionAttribute를 class명 위에 설정한다.
				model.addAttribute("currentUser", memberVO);
				
				//*******************************
				// 수정 필요. redierct   주소 수정 필요.
				//*******************************
				
				String dest = (String)session.getAttribute("dest");
				session.removeAttribute("dest");
				
				if(dest == null) {
					System.err.println("dest가 널입니다");
					return "redirect:/";
					//http://localhost:8080/springboard/	
				}else { //dest가 있으면,   /board/new
					System.out.println("dest: " + dest);
					System.out.println("dest 가 있습니다. redirect:"  + dest);
					return "redirect:"+dest;					
				}

			}
		}
		

	}
	
	
	
}
