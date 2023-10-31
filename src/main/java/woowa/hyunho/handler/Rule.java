package woowa.hyunho.handler;

import woowa.hyunho.utilities.Parse;
import woowa.hyunho.utilities.Compare;

public class Rule {	
	static final int RANDOM_NUMBER_LENGTH = 3;
	static final int SELECTOR_NUMBER_LENGTH = 1;
	static final int[] ALLOW_RANDOM_NUMBER = {1,2,3,4,5,6,7,8,9};
	static final int[] ALLOW_SELECTOR_NUMBER = {1,2};
	
	public static void checkRandomNumber(String randomNumber) {
		isLengthCorrect(randomNumber, RANDOM_NUMBER_LENGTH);
		isStringNumber(randomNumber, RANDOM_NUMBER_LENGTH);
	}
	
	public static void checkSelectorNumber (String selectorNumber) {
		isLengthCorrect(selectorNumber, SELECTOR_NUMBER_LENGTH);
		isStringNumber(selectorNumber, SELECTOR_NUMBER_LENGTH);
	}
	
	private static void isLengthCorrect(String str, int length) {
		if (str.length() != length) {
			throw new IllegalArgumentException(length + " 글자 숫자가 아닙니다.");
		}
	}
	
	private static void isStringNumber(String str, int length) {
		int i=0;
		int[] inputNumberArray = new int[length];
		while (i!=length) {
			char c = str.charAt(i);
			int n = isCharacterNumber(c);
			isIntendedNumber(n, inputNumberArray, length);
			inputNumberArray[i] = n;
			i++;
		}
	}
	
	private static int isCharacterNumber(char c) {
		if (!Character.isDigit(c)) {
			throw new IllegalArgumentException("숫자가 아닙니다.");
		}
		return Parse.parseCharToInt(c);
	}
	
	private static void isIntendedNumber(int n, int[] inputArray,int length) {
		if (isOutOfRange(n,length) || isDuplicate(n,inputArray)) {
			throw new IllegalArgumentException("지정된 숫자가 아닙니다.");
		}
	}
	
	private static boolean isOutOfRange(int n, int length) {
		int[] allowNumber = getAllowNumber(length);
		int check = 0;
		for (int i=0; i < allowNumber.length; i++) {
			check += compareNumber(n, allowNumber[i]);
		}
		if (check!=1) {
			return true;
		}
		return false;
	}
	
	private static boolean isDuplicate(int n, int[] inputArray) {
		int check=0;
		for (int i=0; i<inputArray.length; i++) {
			check += compareNumber(n, inputArray[i]);
		}
		if (check==1) {
			return true;
		}
		return false;
		
	}
 	
	private static int[] getAllowNumber(int length) {
		if (length==RANDOM_NUMBER_LENGTH) {
			return ALLOW_RANDOM_NUMBER;
		}
		return ALLOW_SELECTOR_NUMBER;
	}
	
	private static int compareNumber(int a, int b) {
		if (Compare.compareInt(a, b)) {
			return 1;
		}
		return 0;
	}
}