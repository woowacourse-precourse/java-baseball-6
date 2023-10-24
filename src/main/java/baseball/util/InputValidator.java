package baseball.util;

import baseball.util.Constant;
import baseball.util.Message;

public class InputValidator {
	private void isValidInteger(String Input) {
		try {
			Integer.parseInt(Input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(Message.INPUT_ERROR_MESSAGE);
		}
	}

	private void isValidLength(String Input) {
		if (Input.length() != Constant.NUMBER_LENGTH) {
			throw new IllegalArgumentException(Message.INPUT_ERROR_MESSAGE);
		}
	}

	private void isDistinct(String Input) {
		for (int i = 0; i < Constant.NUMBER_LENGTH; i++) {
			for (int j = i + 1; j < Constant.NUMBER_LENGTH; j++) {
				if (Input.charAt(i) == Input.charAt(j)) {
					throw new IllegalArgumentException(Message.INPUT_ERROR_MESSAGE);
				}
			}
		}
	}

	public void isValidInput(String Input) {
		isValidInteger(Input);
		isValidLength(Input);
		isDistinct(Input);
	}
}
