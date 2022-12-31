import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MainTest {

	@Test
	@DisplayName("input대로 자동차 클래스를 잘 생성하는지 테스트")
	void test1(){
		//given
		String input = "car1,car2,car3";
		String[] expected = new String[]{"car1", "car2", "car3"};
		CarParser carParser = new CarParser();

		//when
		List<Car> cars = carParser.parse(input);
		Set<String> carSet = cars.stream().map(car -> car.getName()).collect(Collectors.toSet());

		//then
		assertThat(cars.size()).isEqualTo(carSet.size());
		for(int i = 0; i < expected.length; i++){
			assertThat(carSet.contains(expected[i])).isTrue();
		}
	}

}