package baseball.exception;

public class DuplicatedInputException extends IllegalArgumentException {
	public DuplicatedInputException(String input) {
		super(input + " : " + "서로 다른 숫자를 입력해야 합니다.");
	}
}
