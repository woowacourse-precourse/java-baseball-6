package baseball;

public class BaseballException extends IllegalArgumentException {
    private BaseballException(String message) {
        super(message);
    }

    public static BaseballException of(ErrorMessage error) {
        return new BaseballException(error.getMessage());
    }
}
