package calc.Calculator2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("calculatorAnnotation02.xml");
		
		MyCalculator myCalculator = context.getBean("myCalculator", MyCalculator.class);
		myCalculator.printResult();
	
	}

}
