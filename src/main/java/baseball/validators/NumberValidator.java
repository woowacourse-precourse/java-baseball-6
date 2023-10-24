package baseball.validators;

public class NumberValidator {

	private static final String NUMERIC_PATTERN = "^[1-9]+$";
	private static final String PLAY_AGAIN_NUMBER = "1";
	private static final String PLAY_END_NUMBER = "2";
	private static final int LENGTH = 3;

	public void isValidPlayGame(String input) {
		if (!isNotBlankOrNull(input) || !isStringOfLength3(input) || !isNumeric(input) || !hasDuplicateNumbers(input)) {
			throw new IllegalArgumentException();
		}
	}

	public void isValidPlayAgain(String input) {
		if (!isNotBlankOrNull(input) || !isNumeric(input) || !isOneOrTwo(input)) {
			throw new IllegalArgumentException();
		}
	}

	public boolean isNotBlankOrNull(String input) {
		return input != null && !input.isBlank();
	}

	public boolean isNumeric(String input) {
		return input.matches(NUMERIC_PATTERN);
	}

	public boolean hasDuplicateNumbers(String input) {
		return input.length() == input.chars().distinct().count();
	}

	public boolean isStringOfLength3(String input) {
		return input.length() == LENGTH;
	}

	public boolean isOneOrTwo(String input) {
		return input.equals(PLAY_AGAIN_NUMBER) || input.equals(PLAY_END_NUMBER);
	}
}