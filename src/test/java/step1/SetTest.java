package step1;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {

	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@Test
	@DisplayName("Set의 크기를 확인하는 테스트")
	void size(){
		int expectedSize = numbers.size();

		assertThat(numbers.size()).isEqualTo(expectedSize);
	}

	@ParameterizedTest(name = "Set에 값이 존재하는지 테스트")
	@ValueSource(ints = {1, 2, 3})
	void contains(int value){
		assertThat(numbers.contains(value)).isTrue();
	}

}
