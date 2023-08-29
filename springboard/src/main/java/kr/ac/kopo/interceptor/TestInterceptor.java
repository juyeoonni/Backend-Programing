package kr.ac.kopo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.kopo.member.vo.MemberVO;

@Component
public class TestInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, 
							HttpServletResponse response, 
							Object handler)
			throws Exception { 
		System.out.println("TestInterceptor preHandle() ");			
		System.out.println("uri: "+request.getRequestURI());
		System.out.println("contextpath: " + request.getContextPath());
		System.out.println("servletpath: " +  request.getServletPath());
		 
		HttpSession session = request.getSession();
		// 정상 login시에 등록했음. POST /login
		MemberVO memberVO = (MemberVO)session.getAttribute("currentUser"); 
		session.setAttribute("dest", request.getServletPath());
		
		if(memberVO != null) { //로그인 되어 있는 경우. true를 return하여 handler에게 제어권 넘김
			System.out.println("로그인 되어 있음");
			System.out.println("prehandle 끝");
			return true;
		}else {
			//로그인 안되어 있는 경우에는   return false를 하고, 
			//redirect 를 해서  login.jsp 로 보낸다. 
			//http://localhost:8080/springboard/login
			System.out.println("로그인 아직 안되어 있어서 login 페이지로 변경함");
			System.out.println("prehandle 끝 - redirect 합니다.");
			response.sendRedirect(request.getContextPath()+"/login");
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, 
							HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TestInterceptor postHandle() ");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	

}
