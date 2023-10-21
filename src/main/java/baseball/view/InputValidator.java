package baseball.view;

import baseball.constants.message.ErrorMessage;

public class InputValidator {
    private static final String NUMERIC_REGEX = "^[1-9]*$";

    public void validateNumeric(String number) {
        if (!number.matches(NUMERIC_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NUMERIC_ERROR.getMessage());
        }
    }
}
