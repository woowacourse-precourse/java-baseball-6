package baseball.validation;

public class NumberValidator {

	public NumberValidator(String playerInputNumber) {
		numberValidateIsThreeNumber(playerInputNumber);
		numberValidateIsDigit(playerInputNumber);
		numberValidateIsSameDigit(playerInputNumber);
		validateForZero(playerInputNumber);
	}

	public void validateForZero(String stringNumber) {
		if (stringNumber.charAt(0) == '0' || stringNumber.charAt(1) == '0' || stringNumber.charAt(2) == '0') {
			throw new IllegalArgumentException();
		}
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

	public boolean isNumeric(String stringNumber) {
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
