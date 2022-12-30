package step1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class AddCalculatorTest {

	AddCalculator addCalculator = new AddCalculator();

	@ParameterizedTest
	@NullAndEmptySource
	void test12(String expression){
		assertThat(addCalculator.add(expression)).isEqualTo(0);
	}

	@ParameterizedTest(name = "숫자 하나만 입력으로 들어온 경우")
	@ValueSource(strings = {"1", "34", "12321"})
	void test3(String number){
		assertThat(addCalculator.add(number)).isEqualTo(Integer.parseInt(number));
	}

	@Test
	@DisplayName(",가 구분자인 경우")
	void test4(){
		String string = "1,2,3";
		int expected = 6;

		assertThat(addCalculator.add(string)).isEqualTo(expected);
	}

	@ParameterizedTest(name = "구분자를 , : 둘 다 사용하는 경우")
	@ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3"})
	void test5(String input){
		int expected = 6;
		assertThat(addCalculator.add(input)).isEqualTo(expected);
	}

	@ParameterizedTest(name = "커스텀 구분자를 지정하는 경우")
	@ValueSource(strings = {"//;\n1;2;3", "//k\n1k2k3", "//]\n1]2]3"})
	void test6(String input){
		int expected = 6;
		assertThat(addCalculator.add(input)).isEqualTo(expected);
	}

	@ParameterizedTest(name = "음수가 포함된 경우 RuntimeException")
	@ValueSource(strings = {"//;\n-1;2;-3", "//k\n-1k2k3", "1,2,-3"})
	void test7(String input){
		assertThatThrownBy(() -> addCalculator.add(input)).isInstanceOf(RuntimeException.class);
	}

}