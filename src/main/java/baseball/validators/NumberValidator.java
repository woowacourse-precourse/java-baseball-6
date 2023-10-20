package baseball.validators;

public class NumberValidator {

	public void isValidPlayGame(String input) {
		if (!isNotBlankOrNull(input) || !isStringOfLength3(input) ||
			!isNumeric(input) || !hasDuplicateNumbers(input)) {
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
		return input.matches("^[1-9]+$");
	}

	public boolean hasDuplicateNumbers(String input) {
		return input.length() == input.chars().distinct().count();
	}

	public boolean isStringOfLength3(String input) {
		return input.length() == 3;
	}

	public boolean isOneOrTwo(String input) {
		return input.equals("1") || input.equals("2");
	}
}