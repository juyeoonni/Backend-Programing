package basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloMain {
	public static void main (String[] args) {
		
//		기존의 자바 작업
//		Hello h1 = new Hello();
//		h1.printHello();
		
//		1. Spring Container 생성한 후 xml 파일을 인자로 전달
//		-> Spring은 이 설정 파일을 읽고 빈을 생성하고 관리
		ApplicationContext context 
		//	= new GenericXmlApplicationContext("basic-beanContainer.xml");
			= new ClassPathXmlApplicationContext("basic-beanContainer.xml");
		
		
//		xml에 정의된 h1, h2 빈 가져와서 사용
		Hello h =(Hello)context.getBean("h1");
		h.printHello();
		
		Hello hh = context.getBean("h2", Hello.class);
		hh.printHello();
		
		System.err.println(h);
		System.err.println(hh);
		
		
	}

}
