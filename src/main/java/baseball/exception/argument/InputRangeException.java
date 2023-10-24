package baseball.exception.argument;

public class InputRangeException extends IllegalArgumentException {

	public InputRangeException() {
		super("입력 범위를 벗어났습니다.");
	}
}
