package baseball.util;

import java.util.HashSet;

import baseball.console.BaseBallConstant;

public class InputValidation {

	public boolean isGameInputValid(String input) {
		final int LENGTH_STANDARD = 3;
		if (input == null || input.length() != LENGTH_STANDARD) {
			return false;
		}
		HashSet<Character> uniqueDigits = new HashSet<>();
		for (char digit : input.toCharArray()) {
			if (digit < '1' || digit > '9' || !uniqueDigits.add(digit)) {
				return false;
			}
		}
		return true;
	}

	public boolean isEndInputValid(String input) {
		final int LENGTH_STANDARD = 1;
		if (input == null || input.length() != LENGTH_STANDARD) {
			return false;
		}
		return input.equals(BaseBallConstant.RESTART.getValue()) || input.equals(BaseBallConstant.FINISH.getValue());
	}
}
