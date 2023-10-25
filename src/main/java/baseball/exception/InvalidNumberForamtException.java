package baseball.exception;

public class InvalidNumberForamtException extends IllegalArgumentException {
    public InvalidNumberForamtException() {
        throw new IllegalArgumentException("숫자가 아닙니다.");
    }
}
