package baseball.exception;

public class InvalidInputException extends IllegalArgumentException {
    public InvalidInputException() {
        super("입력받은 값이 유효하지 않습니다.");
    }
}
