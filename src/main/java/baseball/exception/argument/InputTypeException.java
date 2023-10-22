package baseball.exception.argument;

public class InputTypeException extends IllegalArgumentException {

	public InputTypeException() {
		super("숫자만 입력 가능합니다.");
	}
}
