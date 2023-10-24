package baseball.console.util;

import java.util.HashSet;
import java.util.Set;

import baseball.service.constant.NumberConstant;
import baseball.service.constant.PlayConstant;

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
		return input.equals(PlayConstant.RESTART.getValue()) || input.equals(PlayConstant.FINISH.getValue());
	}

	private boolean isInRange(char digitChar) {
		int digit = Character.getNumericValue(digitChar);
		return NumberConstant.MIN_NUMBER.getValue() <= digit && digit <= NumberConstant.MAX_NUMBER.getValue();
	}
}
