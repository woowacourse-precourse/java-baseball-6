package baseball.exception;

public class DuplicateException extends IllegalArgumentException {
    private DuplicateException(String message) {
        super(message);
    }

    public static DuplicateException of(ErrorMessage error) {
        return new DuplicateException(error.getMessage());
    }
}
