package baseball.exception;

import baseball.constant.ErrorMessage;

public class InvalidAnswerInputException extends IllegalArgumentException {

    public InvalidAnswerInputException() {
        super(ErrorMessage.NUMBER_INPUT_ERROR.toString());
    }
}
