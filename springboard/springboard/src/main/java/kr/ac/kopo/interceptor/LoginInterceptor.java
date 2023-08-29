package kr.ac.kopo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.kopo.member.vo.MemberVO;
//@Component
public class LoginInterceptor implements HandlerInterceptor{
		//loginInterceptor 라는 이름으로 instance를 생성함
	@Override
	public boolean preHandle(HttpServletRequest request, 
								HttpServletResponse response, 
								Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO)session.getAttribute("currentUser");
		
		System.out.println("handler: " + handler);
		System.out.println("request.getContextPath() : "	+ request.getContextPath()); 
		System.out.println("request.getServletPath() : " 	+ request.getServletPath());
		System.out.println("request.getQueryString() : " 	+ request.getQueryString());
		System.out.println("request.getRequestURI() : " 	+ request.getRequestURI());
		
		session.setAttribute("dest", request.getServletPath());
		
		System.out.println("preHandle - 로그인 체크 동작입니다.");
		if(memberVO == null) {  //로그인 안했으면,
			System.out.println("memberVO is null");
			//http://localhost:8080/springboard/login
			response.sendRedirect(request.getContextPath()+"/login");
			return false;
		}
		else { 	//로그인 이미 한 경우
			System.out.println("memberVO 로그인 했음 ");
			return true;
		}
		//System.out.println("preHandle - 로그인 체크 동작입니다.");
		
		// 로그인 안헀으면, 로그인 얼른 하세요. 
		//login.jsp 화면으로 이동 

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("postHandle 동작입니다.");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	} 
	

}
