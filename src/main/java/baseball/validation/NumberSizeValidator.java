package baseball.validation;

import baseball.view.ErrorMessage;

public class NumberSizeValidator {

    private NumberSizeValidator() {
    }

    public static void validate(String number) {
        if (number.length() != 3) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_SIZE.getMessage());
        }
    }
}
