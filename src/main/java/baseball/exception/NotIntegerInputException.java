package baseball.exception;

public class NotIntegerInputException extends IllegalArgumentException{
	public NotIntegerInputException(String input) {
		super(input + " : " + "정수 형태로만 입력해야 합니다.");
	}
}
