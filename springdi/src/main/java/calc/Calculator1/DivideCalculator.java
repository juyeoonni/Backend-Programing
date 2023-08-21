package calc.Calculator1;

import org.springframework.stereotype.Component;

@Component("divideCalculator")
public class DivideCalculator implements Calculator {

	@Override
	public int calculate(int n1, int n2) {
		return n1 % n2;
	}

}
