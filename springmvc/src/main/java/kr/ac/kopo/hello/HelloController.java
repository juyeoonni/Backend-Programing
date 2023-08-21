package kr.ac.kopo.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	// hander 생성 - 메서드 (클라이언트가 요청하면 요청을 실행해주는)
	// http://localhost:8081/springmvc + "/hello/hello"
	@RequestMapping("/hello/hello")
	public ModelAndView hello() {
		
		ModelAndView mav = new ModelAndView("hello/hello");
		mav.addObject("msg", "Hello World");
		// view -> jsp file
		// WEB-INF/jsp/hello/hello.jsp
		return mav;
	}
}
//helloController