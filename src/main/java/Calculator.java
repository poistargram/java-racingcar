import java.util.Objects;

public class Calculator {

	public int run(String expression){
		validate(expression);

		String[] expressionUnit = expression.split(" ");
		return 0;
	}


	// ====================================================================================

	private void validate(String expression) {
		if(Objects.isNull(expression) || expression.isBlank()){
			throw new IllegalArgumentException();
		}
	}
}
