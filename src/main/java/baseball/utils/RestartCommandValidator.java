package baseball.utils;

import java.util.regex.Pattern;

public class RestartCommandValidator {
    private static final int VALID_LENGTH = 1;
    private static final String VALID_RESTART_COMMAND_VALUE_ONE = "1";
    private static final String VALID_RESTART_COMMAND_VALUE_TWO = "2";
    private static final String ONLY_NUMERIC_REGEX = "^[\\d]*$";

    public void validateRestartCommandInput(String restartCommand) {
        validateLength(restartCommand);
        validateNumeric(restartCommand);
        validateOneOrTwo(restartCommand);
    }

    private void validateLength(String input) {
        if (input.length() != VALID_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_LENGTH.getError(input, 1));
        }
    }

    private void validateNumeric(String input) {
        boolean onlyNumeric = Pattern.matches(ONLY_NUMERIC_REGEX, input);
        if (!onlyNumeric) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMERIC.getError(input));
        }
    }

    private void validateOneOrTwo(String input) {
        if (!input.equals(VALID_RESTART_COMMAND_VALUE_ONE) && !input.equals(VALID_RESTART_COMMAND_VALUE_TWO)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_RESTART_COMMAND.getError(input));
        }
    }
}
