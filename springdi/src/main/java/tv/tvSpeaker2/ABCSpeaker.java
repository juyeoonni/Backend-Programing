package tv.tvSpeaker2;

import org.springframework.stereotype.Component;

public class ABCSpeaker implements Speaker {

	@Override
	public void volumeup() {
		System.out.println("ABCSpeaker스피커 볼륨업");
	}
	
	@Override
	public void volumedown() {
		System.out.println("ABCSpeaker스피커 볼륨다운");

	}
	
	@Override
	public String getBrand() {
		return "ABC ";
	}

}
