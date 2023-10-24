package baseball.validator;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
	public static void checkNumber(String input) {
		checkSize(input);
		isDistinct(input);
		isDigit(input);
	}

	public static void isDistinct(String input) {
		Set<Character> numberSet = new HashSet<>();
		for (int i = 0; i < 3; i++) {
			numberSet.add(input.charAt(i));
		}
		if (numberSet.size() != 3) {
			throw new IllegalArgumentException("Distinct Number Detected");
		}

	}

	public static void isDigit(String input) {
		for (int i = 0; i < 3; i++) {
			if ((int) input.charAt(i) < '1' || (int) input.charAt(i) > '9') {
				throw new IllegalArgumentException("Not Digits Detected");
			}
		}
	}

	public static void checkSize(String input) {
		int inputSize = input.length();
		if (inputSize != 3) {
			throw new IllegalArgumentException("Incorrect Size");
		}
	}

	public static void checkRestart(int input) {
		if (input != 1 && input != 2) {
			throw new IllegalArgumentException("Incorrect Number");
		}
	}
}
