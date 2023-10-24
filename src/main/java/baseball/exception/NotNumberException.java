package baseball.exception;

import static baseball.exception.ExceptionConstant.NOT_NUMBER_EXCEPTION;

public class NotNumberException extends IllegalArgumentException {
    public NotNumberException() {
        super(NOT_NUMBER_EXCEPTION);
    }
}
