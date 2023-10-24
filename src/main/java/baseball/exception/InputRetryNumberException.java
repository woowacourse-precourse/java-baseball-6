package baseball.exception;

public class InputRetryNumberException {
	static final int INPUT_LENGTH = 1;
	static final String INPUT_NUMBER_REG = "[1-2]+";

	public void checkRange(String inputNum) {
		if (inputNum.length() != INPUT_LENGTH) {
			throw new IllegalArgumentException("1~2 사이의 숫자를 한 번만 입력하세요.");
		}
	}

	public void checkIsNumeric(String inputNumber) {
		if (!inputNumber.matches(INPUT_NUMBER_REG))
			throw new IllegalArgumentException("1~2 사이의 숫자만 입력하세요.");
	}

	public void checkException(String inputNum) {
		checkRange(inputNum);
		checkIsNumeric(inputNum);
	}
}
