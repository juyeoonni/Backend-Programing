package kr.ac.kopo.method;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MethodController {
	
	@RequestMapping(value = "/method/method",
							method = RequestMethod.GET)
	public String get() {
	// String은 view의 이름을 return값으로 받는다.	
	// WEB-INF/jsp/method/methodForm.jsp		
		return "method/methodForm"; 
	}
	
	@RequestMapping(value = "/method/method",	
							method = RequestMethod.POST)
	public String post() {
		System.out.println("post요청 받았어요");
		return "method/methodProcess";	// 리턴되는 뷰
		// WEB-INF/jsp/method/methodProcess.jsp
	}
}
