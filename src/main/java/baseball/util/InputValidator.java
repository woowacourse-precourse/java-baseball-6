package baseball.util;

public class InputValidator {
	private void isValidInteger(String userInput) {
		try {
			Integer.parseInt(userInput);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(Message.INPUT_ERROR_MESSAGE);
		}
	}

	private void isValidLength(String userInput) {
		if (userInput.length() != Constant.NUMBER_LENGTH) {
			throw new IllegalArgumentException(Message.INPUT_ERROR_MESSAGE);
		}
	}

	private void isDistinct(String userInput) {
		for (int i = 0; i < Constant.NUMBER_LENGTH; i++) {
			for (int j = i + 1; j < Constant.NUMBER_LENGTH; j++) {
				if (userInput.charAt(i) == userInput.charAt(j)) {
					throw new IllegalArgumentException(Message.INPUT_ERROR_MESSAGE);
				}
			}
		}
	}

	public void isValidInput(String userInput) {
		isValidInteger(userInput);
		isValidLength(userInput);
		isDistinct(userInput);
	}
}
