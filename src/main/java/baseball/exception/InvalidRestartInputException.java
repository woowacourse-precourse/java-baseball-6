package baseball.exception;

import static baseball.exception.ErrorMessage.INVALID_INPUT;

public class InvalidRestartInputException extends IllegalArgumentException {
    public InvalidRestartInputException() {
        super(INVALID_INPUT);
    }
}