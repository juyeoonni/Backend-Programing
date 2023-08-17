package di.anno01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DriverMain {
    
    public static void main(String[] args) {
        ApplicationContext context
        = new GenericXmlApplicationContext("spring-anno01.xml");
        
        Car car = (Car) context.getBean("car");
        car.printTireBrand();
    }
}