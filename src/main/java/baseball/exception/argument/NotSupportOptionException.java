package baseball.exception.argument;

public class NotSupportOptionException extends IllegalArgumentException {

	public NotSupportOptionException() {
		super("지원하지 않는 옵션입니다.");
	}
}
