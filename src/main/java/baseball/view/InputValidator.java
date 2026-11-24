package baseball.view;

import baseball.exception.BaseballErrorMessage;
import baseball.exception.BaseballGameException;

public class InputValidator {
    private InputValidator() {
    }

    public static void validate(String input) {
        if (input == null || input.isBlank()) {
            throw new BaseballGameException(BaseballErrorMessage.NULL_OR_BLANK_INPUT);
        }
    }
}
