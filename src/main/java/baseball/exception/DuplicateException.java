package baseball.exception;

public class DuplicateException extends IllegalArgumentException {
    public DuplicateException(String msg) {
        super(msg);
    }
}
