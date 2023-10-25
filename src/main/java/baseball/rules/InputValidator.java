package baseball.rules;

import static baseball.rules.GameConstants.END;
import static baseball.rules.GameConstants.MAX_NUMBER;
import static baseball.rules.GameConstants.MIN_NUMBER;
import static baseball.rules.GameConstants.NUMBER_OF_DIGITS;
import static baseball.rules.GameConstants.RESTART;
import static baseball.message.ErrorMessages.INVALID_DUPLICATE;
import static baseball.message.ErrorMessages.INVALID_RANGE_AND_LENGTH;
import static baseball.message.ErrorMessages.INVALID_RESTART;

public class InputValidator {
    private static final String VALID_INPUT_REGEX = String.format("^[%d-%d]{%d}$", MIN_NUMBER, MAX_NUMBER, NUMBER_OF_DIGITS);

    public static void validatePlayerNumbers(String input) {
        if (!input.matches(VALID_INPUT_REGEX)) {
            throw new IllegalArgumentException(INVALID_RANGE_AND_LENGTH);
        }

        if (input.charAt(0) == input.charAt(1)
                || input.charAt(0) == input.charAt(2)
                || input.charAt(1) == input.charAt(2)) {
            throw new IllegalArgumentException(INVALID_DUPLICATE);
        }
    }

    public static void validateRestartInput(String input) {
        if (!input.equals(RESTART) && !input.equals(END)) {
            throw new IllegalArgumentException(INVALID_RESTART);
        }
    }
}
