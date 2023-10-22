package baseball.exception.argument;

public class InputDuplicateException extends IllegalArgumentException {

	public InputDuplicateException() {
		super("중복된 숫자가 있습니다.");
	}
}
