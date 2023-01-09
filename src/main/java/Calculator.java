import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;
import java.util.Queue;

public class Calculator {

	public static int run(String expression){
		validate(expression);
		Queue<String> expressionUnit = spiltExpression(expression);

		int result = getNumber(expressionUnit.poll());
		while(expressionUnit.size() > 1){
			String operator = expressionUnit.poll();
			String number = expressionUnit.poll();
			result = calculate(result, operator, number);
		}

		if(expressionUnit.size() != 0){
			throw new IllegalArgumentException();
		}
		return result;
	}

	// ====================================================================================

	private static void validate(String expression) {
		if(expression == null || expression.isBlank()){
			throw new IllegalArgumentException();
		}
	}

	private static Queue<String> spiltExpression(String expression){
		return new ArrayDeque<>(Arrays.asList(expression.split(" ")));
	}

	private static int calculate(int first, String operator, String number) {
		if(!isNumber(number)){
			throw new IllegalArgumentException();
		}

		if(!isOperator(operator)){
			throw new IllegalArgumentException();
		}

		int second = Integer.parseInt(number);
		switch (operator){
		case "+":
			return first+second;
		case "-":
			return first-second;
		case "*":
			return first*second;
		case "/":
			return first/second;
		}
		throw new IllegalArgumentException();
	}

	private static int getNumber(String number){
		if(!isNumber(number)){
			throw new IllegalArgumentException();
		}

		return Integer.parseInt(number);
	}

	private static boolean isNumber(String unit){
		char firstChar = unit.charAt(0);
		if(firstChar != '-' && (firstChar < '0' || firstChar > '9')){
			return false;
		}

		for(int i = 1; i < unit.length(); i++){
			char number = unit.charAt(i);
			if(number < '0' || number > '9'){
				return false;
			}
		}

		return true;
	}

	private static boolean isOperator(String operator){
		if(operator.length() != 1) {
			return false;
		}

		char op = operator.charAt(0);
		if(op == '+' || op == '-' || op == '*' || op == '/'){
			return true;
		}

		return false;
	}

}
