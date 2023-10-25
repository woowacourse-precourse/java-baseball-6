package baseball.validation;

public class NumberValidator {
	public NumberValidator(String playerInputNumber) {
		numberValidateIsThreeNumber(playerInputNumber);
		numberValidateIsDigit(playerInputNumber);
		numberValidateIsSameDigit(playerInputNumber);
	}

	public void numberValidateIsSameDigit(String stringNumber) {
		for (int i = 0; i < 2; i++) {
			for (int j = i + 1; j < 3; j++) {
				if (stringNumber.charAt(i) == stringNumber.charAt(j)) {
					throw new IllegalArgumentException();
				}
			}
		}

	}

	public void numberValidateIsDigit(String stringNumber) {
		if (isNumeric(stringNumber)) {
			throw new IllegalArgumentException();
		}
	}

	private static boolean isNumeric(String stringNumber) {
		return stringNumber
			.chars()
			.anyMatch(c -> !(Character.isDigit((char)c)));
	}

	public boolean isThreeNumber(String stringNumber) {
		return stringNumber.length() != 3;
	}

	public void numberValidateIsThreeNumber(String stringNumber) {
		if (isThreeNumber(stringNumber)) {
			throw new IllegalArgumentException();
		}
	}
}
