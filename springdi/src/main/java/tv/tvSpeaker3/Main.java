package tv.tvSpeaker3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
	
	// ApplicationContext에서 "lgtv"라는 이름의 빈 가져오기
	TV tv1 = (TV) context.getBean("lgtv", TV.class);
	
	// ApplicationContext에서 "samsungTV"라는 이름의 빈 가져오기
	TV tv2 = (TV) context.getBean("samsungTV", TV.class);
	
	tv1.turnon();
	tv1.volumeup();
	tv1.volumedown();
	tv1.printSpeakerBrand();
	tv1.turnoff();
	
	System.out.println("-------------------------------");

	tv2.turnon();
	tv2.volumeup();
	tv2.volumedown();
	tv2.printSpeakerBrand();
	tv2.turnoff();
	}
	
}