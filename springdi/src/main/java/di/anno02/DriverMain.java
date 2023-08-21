package di.anno02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DriverMain {
    public static void main(String[] args) {
        ApplicationContext context 
        = new GenericXmlApplicationContext("spring-anno02.xml");
        
        Car car = (Car) context.getBean("car");
        car.printTireBrand();
    }
}