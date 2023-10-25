package baseball.model;

import static baseball.exception.ErrorMessage.INVALID_BALL_NUMBER;
import static baseball.util.InputUtils.INPUT_NUMBERS_REGEX;

public class InputNumbers {

    private String input;

    public InputNumbers(String input) {
        if (!INPUT_NUMBERS_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(INVALID_BALL_NUMBER.toString());
        }

        this.input = input;
    }

    public static InputNumbers of(String input) {
        return new InputNumbers(input);
    }

    public String value() {
        return input;
    }
}
