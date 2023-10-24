package baseball;

public class ChooseValidator {
	String inputString;
	int choose;

	public int validate(String input) {
		inputString = input;
		validateNumber();
		validateValue();
		return choose;
	}

	private void validateNumber() {
		// 숫자 검증
		try {
			choose = Integer.parseInt(inputString);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}
	}

	private void validateValue() {
		// 1, 2인지 검증한다.
		if (choose != 1 && choose != 2) {
			throw new IllegalArgumentException();
		}
	}
}
