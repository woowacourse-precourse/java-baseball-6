package baseball.exception;

public class BaseballGameException extends IllegalArgumentException {
    public BaseballGameException(BaseballErrorMessage message, Object... numbers) {
        super(message.getMessage(numbers));
    }
}
