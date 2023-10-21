package baseball.util;

import java.util.HashSet;
import java.util.Set;

import baseball.constant.GameConstant;
import baseball.constant.NumberConstant;

public class InputValidation {

	public boolean isValidGameInput(String input) {
		if (input == null || input.length() != NumberConstant.GAME_INPUT_LENGTH.getValue()) {
			return false;
		}
		Set<Character> uniqueDigits = new HashSet<>();
		for (char digitChar : input.toCharArray()) {
			if (!isInRange(digitChar) || !uniqueDigits.add(digitChar)) {
				return false;
			}
		}
		return true;
	}

	public boolean isValidEndInput(String input) {
		if (input == null || input.length() != NumberConstant.END_INPUT_LENGTH.getValue()) {
			return false;
		}
		return input.equals(GameConstant.RESTART.getValue()) || input.equals(GameConstant.FINISH.getValue());
	}

	private boolean isInRange(char digitChar) {
		int digit = Character.getNumericValue(digitChar);
		return NumberConstant.MIN_NUMBER.getValue() <= digit && digit <= NumberConstant.MAX_NUMBER.getValue();
	}
}
