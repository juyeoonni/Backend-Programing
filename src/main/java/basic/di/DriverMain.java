package basic.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DriverMain {

    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("spring-xml01.xml");

        // 1. 생성자 주입
        // Car c1 = new Car(new HankookTire());
        Car localcar = (Car) context.getBean("car");
        localcar.printTireBrand();
    
        HankookTire hankook = new HankookTire();
        KumhoTire kumho = new KumhoTire();
        
        // setter를 통한 DI
        Car car = new Car();
        car.setTire(kumho);
        car.printTireBrand();
        
        // 생성자를 통한 DI
        Car car2 = new Car(kumho);
        car.printTireBrand();
        
    
    }

}