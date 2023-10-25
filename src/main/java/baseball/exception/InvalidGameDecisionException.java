package baseball.exception;

import baseball.constant.ErrorMessage;

public class InvalidGameDecisionException extends IllegalArgumentException {

    public InvalidGameDecisionException() {
        super(ErrorMessage.RETRY_INPUT_ERROR.toString());
    }
}
