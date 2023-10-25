package baseball.utils;

import static baseball.utils.ExceptionMessage.INVALID_RESTART_COMMAND;
import static baseball.utils.ExceptionMessage.NOT_NUMERIC;
import static baseball.utils.ExceptionMessage.OUT_OF_LENGTH;

import java.util.regex.Pattern;

public class RestartCommandValidator {

    public void validateRestartCommandInput(String restartCommand) {
        validateLength(restartCommand, 1);
        validateNumeric(restartCommand);
        validateOneOrTwo(restartCommand);
    }

    private void validateLength(String input, int length) {
        if (input.length() != length) {
            throw new IllegalArgumentException(OUT_OF_LENGTH.getError(input, length));
        }
    }

    private void validateNumeric(String input) {
        boolean onlyNumeric = Pattern.matches("^[\\d]*$", input);
        if (!onlyNumeric) {
            throw new IllegalArgumentException(NOT_NUMERIC.getError(input));
        }
    }

    private void validateOneOrTwo(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException(INVALID_RESTART_COMMAND.getError(input));
        }
    }
}
