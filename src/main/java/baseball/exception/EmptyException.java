package baseball.exception;

public class EmptyException extends IllegalArgumentException {
    private EmptyException(String message) {
        super(message);
    }

    public static EmptyException of(ErrorMessage error) {
        return new EmptyException(error.getMessage());
    }
}
