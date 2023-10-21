package baseball.exception;

public class UsingZeroInputException extends IllegalArgumentException {
	public UsingZeroInputException(String input) {
		super(input + " : " + "1부터 9까지의 숫자만 사용해야 합니다.");
	}
}
