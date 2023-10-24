package baseball.validator;

import baseball.exception.InvalidBallNumbersInputException;
import baseball.exception.InvalidGameStatusNumberInputException;
import java.util.regex.Pattern;

public final class InputValidator {

    private static final String NUMBERS_INPUT_REGEX = "^\\d{3}$";
    private static final String GAME_STATUS_INPUT_REGEX = "^\\d{1}$";

    public void validateNumbersInput(final String input) {
        if (!Pattern.matches(NUMBERS_INPUT_REGEX, input)) {
            throw new InvalidBallNumbersInputException();
        }
    }

    public void validateGameStatusInput(final String input) {
        if (!Pattern.matches(GAME_STATUS_INPUT_REGEX, input)) {
            throw new InvalidGameStatusNumberInputException();
        }
    }
}
