package kr.ac.kopo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.kopo.member.vo.MemberVO;

@Component
public class LoginInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
    	
    	System.out.println(handler);
    	System.out.println("request.getContextPath(): " + request.getContextPath());
    	System.out.println("request.getServletPath(): " + request.getServletPath());
    	System.out.println("request.getRequestURI(): " + request.getRequestURI());
    	
    	HttpSession session = request.getSession();
    	MemberVO memberVO = (MemberVO)session.getAttribute("currentUser");
    	System.out.println("preHandle - 로그인 체크 동작입니다.");
    	if(memberVO == null) {	// 로그인 안한 경우
    		System.out.println("memberVO is null");
    		response.sendRedirect(request.getContextPath()+"/login");
    		return false;
    	} else {	// 로그인 이미 한 경우
    		System.out.println("memberVO 로그인했음");
    		return true;
    	}
        
    }

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle 동작입니다.");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
    
}