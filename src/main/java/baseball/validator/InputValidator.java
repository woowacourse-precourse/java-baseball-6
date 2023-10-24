package baseball.validator;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {

	private final static int MAX_NUMBER_SIZE = 3;

	public static void checkNumber(String input) {
		checkSize(input);
		isDistinct(input);
		isDigit(input);
	}

	public static void isDistinct(String input) {
		Set<Character> numberSet = new HashSet<>();
		for (int i = 0; i < MAX_NUMBER_SIZE; i++) {
			numberSet.add(input.charAt(i));
		}
		if (numberSet.size() != MAX_NUMBER_SIZE) {
			throw new IllegalArgumentException("Distinct Number Detected");
		}

	}

	public static void isDigit(String input) {
		for (int i = 0; i < MAX_NUMBER_SIZE; i++) {
			if (input.charAt(i) < '1' || input.charAt(i) > '9') {
				throw new IllegalArgumentException("Not Digits Detected");
			}
		}
	}

	public static void checkSize(String input) {
		int inputSize = input.length();
		if (inputSize != MAX_NUMBER_SIZE) {
			throw new IllegalArgumentException("Incorrect Size");
		}
	}

	public static void checkRestart(int input) {
		if (input != 1 && input != 2) {
			throw new IllegalArgumentException("Incorrect Number");
		}
	}
}
