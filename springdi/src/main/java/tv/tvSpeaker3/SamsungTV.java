package tv.tvSpeaker3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("samsungTV")
public class SamsungTV implements TV {

	private Speaker leftspeaker;
	private Speaker rightspeaker;
	
	@Autowired
    public SamsungTV(@Qualifier("abcs") Speaker leftSpeaker, @Qualifier("xyzs") Speaker rightSpeaker) {
        this.leftspeaker = leftSpeaker;
        this.rightspeaker = rightSpeaker;
    }
	
	@Override
	public void turnon() {
		System.out.println("삼성tv 켜짐");
		
	}
	
	@Override
	public void turnoff() {
		System.out.println("삼성tv 꺼짐");
	}
	
	@Override
	public void volumeup() {
		System.out.println("삼성tv 볼륨업");

	}

	@Override
	public void volumedown() {
		System.out.println("삼성tv 볼륨다운");

	}

	@Override
	public void printSpeakerBrand() {
		System.out.println("left speaker 브랜드는 " + leftspeaker.getBrand() + ", " + "right speaker 브랜드는 " + rightspeaker.getBrand());
	}

	

}

