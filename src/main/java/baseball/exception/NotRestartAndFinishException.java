package baseball.exception;

import static baseball.exception.ExceptionConstant.NOT_RESTART_AND_FINISH;

public class NotRestartAndFinishException extends IllegalArgumentException {
    public NotRestartAndFinishException() {
        super(NOT_RESTART_AND_FINISH);
    }
}
