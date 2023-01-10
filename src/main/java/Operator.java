import java.util.Arrays;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Operator {

	PLUS("+", Integer::sum),
	MINUS("-", (first, second) -> first-second),
	MULTIPLY("*", (first, second) -> first*second),
	DIVIDE("/", (first, second) -> first/second);

	private final String value;
	private final BiFunction<Integer, Integer, Integer> function;

	private static Map<String, Operator> operators = Arrays.stream(Operator.values()).collect(Collectors.toMap(operator -> operator.value, Function.identity()));

	Operator(String value, BiFunction<Integer, Integer, Integer> function) {
		this.value = value;
		this.function = function;
	}

	public int operate(int first, int second){
		return this.function.apply(first, second);
	}

	public static Operator from(String value){
		if(!operators.containsKey(value)){
			throw new IllegalArgumentException();
		}

		return operators.get(value);
	}

}
