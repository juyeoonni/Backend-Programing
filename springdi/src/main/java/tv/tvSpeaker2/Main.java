package tv.tvSpeaker2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context 
        = new GenericXmlApplicationContext("tvSpeakerAnnotation02.xml");
	
	// ApplicationContext에서 "lgtv"라는 이름의 빈 가져오기
	TV tv = (TV) context.getBean("lgtv", TV.class);
	
	tv.turnon();
	tv.volumeup();
	tv.volumedown();
	tv.printSpeakerBrand();
	tv.turnoff();
	}
	
}