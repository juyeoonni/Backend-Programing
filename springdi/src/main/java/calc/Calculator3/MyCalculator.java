package calc.Calculator3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myCalculator")
public class MyCalculator {
	int firstNum = 10;
	int secondNum = 3;
	
	private Calculator calculator;
	
	public MyCalculator() {
		System.out.println("MyCalculator()의 생성자입니다.");
	}
	
	@Autowired
	public MyCalculator(@Qualifier("addCalculator") Calculator calculator) {
		this.calculator = calculator;
		System.out.println("MyCalculator(Calculator calculator)의 생성자입니다.");
	}

	public int getFirstNum() {
		return firstNum;
	}

	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}

	public int getSecondNum() {
		return secondNum;
	}

	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}

	public Calculator getCalculator() {
		return calculator;
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
	public void printResult(){
		System.out.println("결과는" + calculator.calculate(firstNum, secondNum));
	}
	
}
