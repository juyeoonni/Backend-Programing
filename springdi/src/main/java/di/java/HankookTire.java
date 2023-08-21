package di.java;

import org.springframework.stereotype.Component;

@Component("h")
public class HankookTire implements Tire{

    @Override
    public String getTireBrand() {
        
        return "한국타이어";
    }

}