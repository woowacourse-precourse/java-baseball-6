package baseball.exception;

public class OutOfLengthInputException extends IllegalArgumentException {
	public OutOfLengthInputException(String input, int N) {
		super(input + " : " + N + "개의 정수를 입력해야 합니다.");
	}
}
