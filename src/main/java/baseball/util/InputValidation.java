package baseball.util;

import java.util.HashSet;

import baseball.console.constant.GameConstant;
import baseball.controller.constant.NumberConstant;

public class InputValidation {

	public boolean isValidGameInput(String input) {
		if (input == null || input.length() != NumberConstant.GAME_INPUT_LENGTH.getValue()) {
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

	public boolean isValidEndInput(String input) {
		if (input == null || input.length() != NumberConstant.END_INPUT_LENGTH.getValue()) {
			return false;
		}
		return input.equals(GameConstant.RESTART.getValue()) || input.equals(GameConstant.FINISH.getValue());
	}
}
