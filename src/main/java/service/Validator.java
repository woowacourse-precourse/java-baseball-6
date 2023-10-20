package service;

public class Validator {
	public Validator() {

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
