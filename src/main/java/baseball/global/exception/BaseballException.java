package baseball.global.exception;

public class BaseballException extends IllegalArgumentException {
    private BaseballException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    public static BaseballException of(ErrorMessage errorMessage) {
        return new BaseballException(errorMessage);
    }
}
