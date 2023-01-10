import java.util.Queue;

public class Calculator {

	public static int run(String expression){
		Queue<String> expressionUnit = ExpressionParser.parse(expression);

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

	private static int calculate(int first, String operator, String number) {
		if(!isNumber(number)){
			throw new IllegalArgumentException();
		}

		int second = Integer.parseInt(number);
		return Operator.from(operator).operate(first, second);
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

}
