package baseball.exception;

import baseball.constant.ErrorMessage;

public class InvalidRetryInputException extends IllegalArgumentException {

    public InvalidRetryInputException() {
        super(ErrorMessage.RETRY_INPUT_ERROR.toString());
    }
}
