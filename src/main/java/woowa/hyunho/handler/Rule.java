package woowa.hyunho.handler;

public class Rule {	
	static final int RANDOM_NUMBER_LENGTH = 3;
	static final int SELECTOR_NUMBER_LENGTH = 1;
	
	public static void checkRandomNumber(String randomNumber) {
		isLengthCorrect(randomNumber, RANDOM_NUMBER_LENGTH);
		isStringNumber(randomNumber, RANDOM_NUMBER_LENGTH);
	}
	
	public static void checkSelectorNumber (String selectorNumber) {
		isLengthCorrect(selectorNumber, SELECTOR_NUMBER_LENGTH);
		isStringNumber(selectorNumber, SELECTOR_NUMBER_LENGTH);
	}
	
	private static void isLengthCorrect(String str, int n) {
		if (str.length() != n) {
			throw new IllegalArgumentException(n + " 글자 숫자가 아닙니다.");
		}
	}
	
	private static void isStringNumber(String str, int n) {
		int i=0;
		while (n!=0) {
			isCharacterNumber(str.charAt(i));
			i++;
			n--;
		}
	}
	
	private static void isCharacterNumber(char c) {
		if (!Character.isDigit(c)) {
			throw new IllegalArgumentException("숫자가 아닙니다.");
		}
	}
}