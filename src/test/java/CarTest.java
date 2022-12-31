import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

	@ParameterizedTest(name = "자동차 상태 테스트")
	@CsvSource(value = {"1:0", "2:0", "3:0","4:0", "5:1", "6:1","7:1", "8:1", "9:1"}, delimiter = ':')
	void test1(int number, int expected){
		// given
		Car car = new Car("test", 0);

		//when
		car.attempt(number);

		//then
		assertThat(car.getState()).isEqualTo(expected);
	}


}