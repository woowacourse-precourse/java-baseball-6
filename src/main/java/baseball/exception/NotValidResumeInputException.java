package baseball.exception;

public class NotValidResumeInputException extends IllegalArgumentException {
	public NotValidResumeInputException(String input) {
		super(input + " : " + "1 또는 2중 하나만 입력해야 합니다.");
	}
}
