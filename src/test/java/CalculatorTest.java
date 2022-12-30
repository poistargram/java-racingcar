import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	Calculator calculator = new Calculator();

	@Test
	@DisplayName("수식이 null인 경우 IllegalArgumentException")
	void expressionNull(){
		Assertions.assertThatThrownBy(() -> calculator.run(null)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("수식이 공백인 경우 IllegalArgumentException")
	void expressionBlank(){
		Assertions.assertThatThrownBy(() -> calculator.run(null)).isInstanceOf(IllegalArgumentException.class);
	}
}