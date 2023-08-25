package kr.ac.kopo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import kr.ac.kopo.member.vo.MemberVO;

@Component
public class TestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
        System.out.println("TestInterceptor preHandle() ");
        
        System.out.println("request.getServletPath(): " +request.getServletPath());
        System.out.println("request.getContextPath(): " +request.getContextPath());
        System.out.println("request.getRequestURI(): " +request.getRequestURI());       
        
        
        
        HttpSession session = request.getSession();
        MemberVO memberVO = (MemberVO)session.getAttribute("currentUser");  //정상 로그인시에 등록된 session
        
        session.setAttribute("dest", request.getServletPath());        
       
        if(memberVO != null) {   
            System.out.println("로그인 되어 있음");
            return true;
        }
        else {
        System.out.println("로그인 안되어 있어서 login 페이지로 변경함");
        //http://localhost:8080/springboard/login으로 보낸다
        response.sendRedirect(request.getContextPath()+"/login");
        return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }


}