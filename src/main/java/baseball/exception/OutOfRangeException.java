package baseball.exception;

public class OutOfRangeException extends IllegalArgumentException {
    public OutOfRangeException(String msg) {
        super(msg);
    }
}
