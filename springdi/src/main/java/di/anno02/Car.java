package di.anno02;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

public class Car {

    @Resource
    private Tire tire;

    public Car() {
        System.out.println("Car() 생성자입니다.");
    }
    

    public Car(Tire t) {
        this.tire = t;
        System.out.println("Car(Tire t) 생성자입니다.");
    }
    
    public Tire getTire() {
        return tire;
    }
    
   
    public void setTire(Tire tire) {
        this.tire = tire;
    }

    public void printTireBrand() {
        System.out.println("타이어브랜드는 " + tire.getTireBrand());
    }

}