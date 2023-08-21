package tv.tvSpeaker3;

import org.springframework.stereotype.Component;

@Component("xyzs")
public class XYZSpeaker implements Speaker {
	
	@Override
	public void volumeup() {
		System.out.println("XYZSpeaker스피커 볼륨업");
	}
	
	@Override
	public void volumedown() {
		System.out.println("XYZSpeaker스피커 볼륨다운");

	}
	
	@Override
	public String getBrand() {
		return "XYZ "; 
	}

}