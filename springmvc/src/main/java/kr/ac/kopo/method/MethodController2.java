package kr.ac.kopo.method;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MethodController2 {
	
	@GetMapping("/method/method")
	public String get() {
	// String은 view의 이름을 return값으로 받는다.	
	// WEB-INF/jsp/method/methodForm.jsp		
		return "method/methodForm"; 
	}
	
	@PostMapping("/method/method")
	public String post() {
		System.out.println("post요청 받았어요");
		return "method/methodProcess";	// 리턴되는 뷰
		// WEB-INF/jsp/method/methodProcess.jsp
	}
}
