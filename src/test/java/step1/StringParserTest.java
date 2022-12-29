package step1;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringParserTest {

	@Test
	@DisplayName("regex 단위로 문자열이 파싱되는지 테스트")
	void parseOneTwo(){
		String string = "1,2";
		String regex = ",";

		String[] parsedString = StringParser.parse(string, regex);
		contains(parsedString, "1");
	}

	@Test
	@DisplayName("문자열 하나만 정확히 파싱하는지 테스트")
	void parseOnlyOne(){
		String string = "1";
		String regex = ",";

		String[] parsedString = StringParser.parse(string, regex);
		containsExactly(parsedString, "1");
	}

	@Test
	@DisplayName("부분 문자열을 잘 반환하는지 테스트")
	void subString(){
		String string = "(1,2)";
		int from = 1;
		int to = string.length()-1;
		String expectedString = "1,2";

		assertThat(StringParser.subString(string, from, to)).isEqualTo(expectedString);
	}

	@Test
	@DisplayName("문자열에서 특정 인덱스의 문자를 잘 가져오는지 테스트")
	void charAt(){
		String string = "abc";
		int index = 0;
		char expectedChar = 'a';

		assertThat(StringParser.charAt(string, index)).isEqualTo(expectedChar);
	}

	@Test
	@DisplayName("문자열의 특정 인덱스 문자를 가져올 때 인덱스 범위를 벗어난 경우 1")
	void charAtException1(){
		String string = "abc";
		int index = -1;
		assertThatThrownBy(() -> StringParser.charAt(string, index)).isInstanceOf(StringIndexOutOfBoundsException.class);
	}

	@Test
	@DisplayName("문자열의 특정 인덱스 문자를 가져올 때 인덱스 범위를 벗어난 경우 2")
	void charAtException2(){
		String string = "abc";
		int index = string.length();
		assertThatThrownBy(() -> StringParser.charAt(string, index)).isInstanceOf(StringIndexOutOfBoundsException.class);
	}

	private void contains(String[] array, String object){
		assertThat(array).contains(object);
	}

	private void containsExactly(String[] array, String object){
		assertThat(array).containsExactly(object);
	}

}