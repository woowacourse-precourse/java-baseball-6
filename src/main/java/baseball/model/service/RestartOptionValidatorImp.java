package baseball.model.service;

import static baseball.model.constants.Exception.RESTART_OPTION_LENGTH_INVALID;
import static baseball.model.constants.Exception.RESTART_OPTION_NON_NUMBER;
import static baseball.model.constants.Exception.RESTART_OPTION_RANGE_INVALID;
import static baseball.model.constants.Rule.RESTART_OPTION_MAX_VALUE;
import static baseball.model.constants.Rule.RESTART_OPTION_MIN_VALUE;
import static baseball.model.constants.Rule.RESTART_OPTION_SIZE;

public class RestartOptionValidatorImp implements RestartOptionValidator {
    @Override
    public void validateRestartOption(String inputOption) {
        isNumber(inputOption);
        isLength(inputOption);
        isRange(inputOption);
    }

    private static void isNumber(String inputOption) {
        inputOption.chars().forEach(ch -> {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException(RESTART_OPTION_NON_NUMBER.getMessage());
            }
        });
    }

    private static void isLength(String inputOption) {
        if (inputOption.length() != RESTART_OPTION_SIZE.getValue()) {
            throw new IllegalArgumentException(RESTART_OPTION_LENGTH_INVALID.getMessage());
        }
    }

    private static void isRange(String inputOption) {
        int num = Integer.parseInt(inputOption);
        if (num < RESTART_OPTION_MIN_VALUE.getValue() || num > RESTART_OPTION_MAX_VALUE.getValue()) {
            throw new IllegalArgumentException(RESTART_OPTION_RANGE_INVALID.getMessage());
        }
    }
}