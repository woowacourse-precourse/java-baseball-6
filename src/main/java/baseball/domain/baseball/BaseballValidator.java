package baseball.domain.baseball;

import static baseball.domain.baseball.BaseballConst.*;

public class BaseballValidator {

    private static final BaseballValidator instance = new BaseballValidator();

    private BaseballValidator() {
    }

    public static BaseballValidator getInstance() {
        return instance;
    }

    public static void validateInput(final String input) {
        validateInputDigit(input);

    }

    private static void validateInputDigit(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ILLEGAL_INPUT_DIGIT_MESSAGE);
        }
    }

    public static void validateCommand(String command) {
        try {
            Integer.parseInt(command);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ILLEGAL_FINISH_COMMAND_MESSAGE);
        }
    }
}
