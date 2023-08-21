package tv.tvSpeaker2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class LGTV implements TV {
	
	private Speaker leftspeaker;
	private Speaker rightspeaker;
	
	@Autowired
	public LGTV(Speaker leftspeaker, Speaker rightspeaker) {
		this.leftspeaker = leftspeaker;
		this.rightspeaker = rightspeaker;
	}

	@Override
	public void turnon() {
		System.out.println("LGtv 켜짐");

	}
	
	@Override
	public void turnoff() {
		System.out.println("LGtv 꺼짐");

	}
	
	@Override
	public void volumeup() {
		System.out.println("LGtv 볼륨업");

	}
	
	@Override
	public void volumedown() {
		System.out.println("LGtv 볼륨다운");

	}

	@Override
	public void printSpeakerBrand() {
		System.out.println("left speaker 브랜드는 " + leftspeaker.getBrand() + "right speaker 브랜드는 " + rightspeaker.getBrand());
	}

}