package baseball.exception;

import baseball.constant.ErrorMessage;

public class InvalidNumberInputException extends IllegalArgumentException {

    public InvalidNumberInputException() {
        super(ErrorMessage.NUMBER_INPUT_ERROR.toString());
    }
}
