package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddCalculator {

	private final static String DEFAULT_DELIMITER = "[,|:]";
	private final static String PATTERN = "//(.)\\n(.*)";

	public int add(String string){
		if(string == null){
			return 0;
		}

		String[] numbers = parseNumbers(string);
		return addNumbers(numbers);
	}

	// ============================================================================================================================

	private String[] parseNumbers(String string){
		Matcher matcher = Pattern.compile(PATTERN).matcher(string);
		if(matcher.find()){
			return StringParser.parse(matcher.group(2), matcher.group(1));
		}

		return StringParser.parse(string, DEFAULT_DELIMITER);
	}

	private int addNumbers(String[] numbers) {
		int result = 0;

		for(int i = 0; i < numbers.length; i++){
			validateNumber(numbers[i]);
			int number = getNumber(numbers[i]);
			result += number;
		}
		return result;
	}

	private int getNumber(String number) {
		if(number.isBlank()){
			return 0;
		}
		return Integer.parseInt(number);
	}

	private void validateNumber(String number){
		for(int i = 0; i < number.length(); i++){
			isNumber(number.charAt(i));
		}
	}

	private void isNumber(char value){
		if(value >= '0' && value <= '9'){
			return;
		}
		throw new RuntimeException();
	}

}
