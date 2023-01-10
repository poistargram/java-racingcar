import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class ExpressionParser {

	public static Queue<String> parse(String expression){
		validate(expression);
		return new ArrayDeque<>(Arrays.asList(expression.split(" ")));
	}

	private static void validate(String expression) {
		if(expression == null || expression.isBlank()){
			throw new IllegalArgumentException();
		}
	}

}
