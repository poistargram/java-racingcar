package step1;

public class StringParser {

	public static String[] parse(String string, String regex){
		return string.split(regex);
	}

	public static String subString(String string, int from, int to){
		return string.substring(from, to);
	}

	public static char charAt(String string, int index){
		return string.charAt(index);
	}

}
