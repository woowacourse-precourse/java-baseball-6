package baseball.exception;

public class InvalidInputException extends IllegalArgumentException {
    private InvalidInputException(String message) {
        super(message);
    }

    public static InvalidInputException of(ErrorMessage error) {
        return new InvalidInputException(error.getMessage());
    }
}
