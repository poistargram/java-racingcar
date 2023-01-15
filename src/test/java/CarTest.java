import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

class CarTest {

//	@ParameterizedTest(name = "자동차 상태 테스트")
//	@CsvSource(value = {"1:0", "2:0", "3:0","4:0", "5:1", "6:1","7:1", "8:1", "9:1"}, delimiter = ':')

	@Test
	@DisplayName("자동차 이름이 잘 초기화되는지 테스트")
	public void test1(){
		// given
		String carName = "poi-Tesla-ModelS";

		// when
		Car car = new Car(carName, 0);

		//then
		assertThat(car.getName()).isEqualTo(carName);
		assertThat(car.getState()).isEqualTo(0);
	}

	@Test
	@DisplayName("자동차 주행 테스트: 인풋이 4이상인 경우만 전진")
	@RepeatedTest(value = 10)
	public void test2(){
		// given
		String carName = "poi-Tesla-ModelS";
		Car runSuccess = new Car(carName, 0);
		Car runFail = new Car(carName, 0);

		// when
		runSuccess.attempt(getLessThanInput(4));
		runFail.attempt(getMoreThanInput(5));

		//then
		assertThat(runSuccess.getState()).isEqualTo(0);
		assertThat(runFail.getState()).isEqualTo(1);
	}

	private int getLessThanInput(int input){
		return ((int) (Math.random() * 10000)) % (input + 1);
	}

	private int getMoreThanInput(int input){
		int ret = ((int) (Math.random() * 10000)) % (input + 1);
		ret = ret >= 0 ? ret : ret*-1;
		ret = ret >= input ? input : ret+input;
		return ret;
	}

}