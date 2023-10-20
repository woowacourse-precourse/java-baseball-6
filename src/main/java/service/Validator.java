package service;

public class Validator {
	public Validator() {

	}
	public boolean checkNumber (int inputNumber) {
		String input = Integer.toString(inputNumber);
		boolean isNatural = true;
		for (int i = 0; i < 3; i++) {
			if (input.charAt(i) == '0') {
				isNatural = false;
				break;
			}
		}
		return isNatural;
	}
	public boolean checkDigit(int inputNumber) {
		boolean isCorrectDigit = false;
		if (inputNumber < 1000 && inputNumber > 99) {
			isCorrectDigit = true;
		}
		return isCorrectDigit;
	}
	public boolean checkDuplication(int inputNumber) {
		boolean isNotDuplicate = false;
		String StringInput = Integer.toString(inputNumber);
		char firstNumber = StringInput.charAt(0);
		char secondNumber = StringInput.charAt(1);
		char thirdNumber = StringInput.charAt(2);

		if (firstNumber != secondNumber && firstNumber != thirdNumber && secondNumber != thirdNumber) {
			isNotDuplicate = true;
		}
		return isNotDuplicate;
	}
}
