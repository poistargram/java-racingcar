package step1;

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

	private void contains(String[] array, String object){
		Assertions.assertThat(array).contains(object);
	}

	private void containsExactly(String[] array, String object){
		Assertions.assertThat(array).containsExactly(object);
	}

}