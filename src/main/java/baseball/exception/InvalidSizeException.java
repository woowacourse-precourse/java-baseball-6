package baseball.exception;

public class InvalidSizeException extends IllegalArgumentException {
    private InvalidSizeException(String message) {
        super(message);
    }

    public static InvalidSizeException of(ErrorMessage error) {
        return new InvalidSizeException(error.getMessage());
    }
}
