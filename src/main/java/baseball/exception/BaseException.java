package baseball.exception;

public class BaseException extends IllegalArgumentException {
    private static final String ERROR_PREFIX = "[ERROR] ";

    public BaseException(ErrorMessage errorMessage) {
        super(ERROR_PREFIX + errorMessage.getMessage());
    }
}
