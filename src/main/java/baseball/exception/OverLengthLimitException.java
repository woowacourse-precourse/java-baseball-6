package baseball.exception;

import static baseball.exception.ExceptionConstant.OVER_LENGTH_LIMIT;

public class OverLengthLimitException extends IllegalArgumentException {
    public OverLengthLimitException() {
        super(OVER_LENGTH_LIMIT);
    }
}
