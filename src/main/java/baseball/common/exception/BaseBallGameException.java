package baseball.common.exception;

public class BaseBallGameException extends IllegalArgumentException {

    public BaseBallGameException(BaseBallExceptionMessage exceptionMessage) {
        super(exceptionMessage.getExceptionMessage());
    }
}
