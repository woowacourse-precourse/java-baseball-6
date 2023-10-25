package baseball.exception;

public class InvalidLengthException extends IllegalArgumentException{
    public InvalidLengthException() {
        throw new IllegalArgumentException("길이가 유효하지 않습니다.");
    }
}
