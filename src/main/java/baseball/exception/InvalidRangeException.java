package baseball.exception;

import static baseball.exception.ErrorMessage.INVALID_RANGE;

public class InvalidRangeException extends IllegalArgumentException {
    public InvalidRangeException() {
        super(INVALID_RANGE);
    }
}
