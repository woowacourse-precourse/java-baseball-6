package baseball.exception;

import static baseball.exception.ExceptionConstant.UNDER_LENGTH_LIMIT;

public class UnderLengthLimitException extends IllegalArgumentException {
    public UnderLengthLimitException() {
        super(UNDER_LENGTH_LIMIT);
    }
}
