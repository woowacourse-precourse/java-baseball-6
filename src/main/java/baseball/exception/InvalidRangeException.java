package baseball.exception;

public class InvalidRangeException extends IllegalArgumentException {
    private InvalidRangeException(String message) {
        super(message);
    }

    public static InvalidRangeException of(ErrorMessage error) {
        return new InvalidRangeException(error.getMessage());
    }
}
