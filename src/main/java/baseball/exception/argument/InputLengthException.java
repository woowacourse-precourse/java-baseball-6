package baseball.exception.argument;

public class InputLengthException extends IllegalArgumentException {

	public InputLengthException() {
		super("입력 길이가 맞지 않습니다.");
	}
}
