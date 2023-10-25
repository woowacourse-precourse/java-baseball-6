package baseball.io;

import baseball.constant.ErrorMessage;

public class InputValidator {

    private static final char MIN_NUMBER = '0';
    private static final char MAX_NUMBER = '9';
    private static final int COMMAND_LENGTH = 1;

    public void validateNumber(final String input) {
        if (hasNonNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.toValue());
        }
    }

    private boolean hasNonNumeric(final String input) {
        return input.chars().anyMatch(this::isNotNumeric);
    }

    private boolean isNotNumeric(final int element) {
        return MIN_NUMBER > element || element > MAX_NUMBER;
    }

    public void validateRetryCommand(final String input) {
        if (isInvalidCommand(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RETRY_COMMAND.toValue());
        }
    }

    private boolean isInvalidCommand(final String input) {
        return input.length() != COMMAND_LENGTH || hasNonNumeric(input);
    }
}
