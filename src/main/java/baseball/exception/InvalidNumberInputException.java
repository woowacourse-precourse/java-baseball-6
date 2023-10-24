package baseball.exception;

import static baseball.exception.ErrorMessage.INVALID_INPUT;

public class InvalidNumberInputException extends IllegalArgumentException {
    public InvalidNumberInputException() {
        super(INVALID_INPUT);
    }
}
