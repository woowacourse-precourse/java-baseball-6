package baseball.exception;

import static baseball.exception.ExceptionConstant.DUPLICATION_NUMBER_EXCEPTION;

public class DuplicationNumberException extends IllegalArgumentException {
    public DuplicationNumberException() {
        super(DUPLICATION_NUMBER_EXCEPTION);
    }
}
