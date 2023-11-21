package baseball.exception;

public class NotNumericException extends IllegalArgumentException {
    private NotNumericException(String message) {
        super(message);
    }

    public static NotNumericException of(ErrorMessage error) {
        return new NotNumericException(error.getMessage());
    }
}
