import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

	Calculator calculator = new Calculator();

	@Test
	@DisplayName("수식이 null인 경우 IllegalArgumentException")
	void test1(){
		assertThatThrownBy(() -> calculator.run(null)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("수식이 공백인 경우 IllegalArgumentException")
	void test2(){
		assertThatThrownBy(() -> calculator.run("")).isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest(name = "계산을 잘 수행하는지 테스트")
	@CsvSource(value = {"1 + 2:3", "1 - 2 + 3:2", "1 * 2 + 3 + 4:9", "4 - 2 / 3 * 6 + 7:7"}, delimiter = ':')
	void test3(String expression, int expected){
		assertThat(calculator.run(expression)).isEqualTo(expected);
	}

	@ParameterizedTest(name = "음수 피연산자가 포함된 계산을 잘 수행하는지 테스트")
	@CsvSource(value = {"1 + 2 - -3:6", "1 - 2 + 3 * -2:-4", "1 * 2 + 3 + 4:9", "4 - 2 / 3 * 6 + 7:7"}, delimiter = ':')
	void test4(String expression, int expected){
		assertThat(calculator.run(expression)).isEqualTo(expected);
	}

	@ParameterizedTest(name = "사칙연산 외 기호가 들어온 경우 IllegalArgumentException")
	@ValueSource(strings = {"1 $ 2", "3 # 7", "9 ~ 2"})
	void test5(String expression){
		assertThatThrownBy(() -> calculator.run(expression)).isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest(name = "숫자의 형태가 이상하게 들어온 경우 IllegalArgumentException")
	@ValueSource(strings = {"1 + 2x9", "3()1 - 7", "(9) ~ 2"})
	void test6(String expression){
		assertThatThrownBy(() -> calculator.run(expression)).isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest(name = "연산자의 개수가 많은 경우 IllegalArgumentException")
	@ValueSource(strings = {"1 + 29 -", "+ 31 - 7", "9 / 2 * /"})
	void test7(String expression){
		assertThatThrownBy(() -> calculator.run(expression)).isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest(name = "수식의 개수가 많은 경우 IllegalArgumentException")
	@ValueSource(strings = {"1 + 29 9", "1 31 - 7", "9 / 2 3 9"})
	void test8(String expression){
		assertThatThrownBy(() -> calculator.run(expression)).isInstanceOf(IllegalArgumentException.class);
	}
}