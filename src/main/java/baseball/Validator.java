package baseball;

import static baseball.constants.ErrorMessages.EMPTY_INPUT_MSG;
import static baseball.constants.ErrorMessages.INVALID_NUMBER_MSG;
import static baseball.constants.ErrorMessages.INVALID_SIZE_MSG;

public class Validator {
    public void checkValidNumber(String input) {

        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(INVALID_NUMBER_MSG);
        }
    }

    public void checkInputSize(String input, int requiredSize) {
        checkNotEmpty(input);
        if (input.length() != requiredSize) {
            throw new IllegalArgumentException(INVALID_SIZE_MSG);
        }
    }

    public void checkNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_MSG);
        }
    }
}