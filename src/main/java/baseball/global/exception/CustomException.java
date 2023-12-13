package baseball.global.exception;

public class CustomException extends IllegalArgumentException {
    private static final String PREFIX = "[ERROR] ";

    private CustomException(ErrorMessage errorMessage) {
        super(PREFIX + errorMessage.getMessage());
    }

    public static CustomException from(ErrorMessage errorMessage) {
        return new CustomException(errorMessage);
    }
}
