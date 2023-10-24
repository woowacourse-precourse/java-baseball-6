package baseball.model.service;

import static baseball.model.constants.ExceptionMessages.RESTART_OPTION_LENGTH_INVALID;
import static baseball.model.constants.ExceptionMessages.RESTART_OPTION_NON_NUMBER;
import static baseball.model.constants.ExceptionMessages.RESTART_OPTION_RANGE_INVALID;
import static baseball.model.constants.GameConstants.RESTART_OPTION_MAX_VALUE;
import static baseball.model.constants.GameConstants.RESTART_OPTION_MIN_VALUE;
import static baseball.model.constants.GameConstants.RESTART_OPTION_SIZE;

public class RestartOptionValidatorImp implements RestartOptionValidator {
    @Override
    public void validateRestartOption(String inputOption) {
        isNumber(inputOption);
        isLength(inputOption);
        isRange(inputOption);
    }

    private void isNumber(String inputOption) {
        inputOption.chars().forEach(ch -> {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException(RESTART_OPTION_NON_NUMBER);
            }
        });
    }

    private void isLength(String inputOption) {
        if (inputOption.length() != RESTART_OPTION_SIZE) {
            throw new IllegalArgumentException(RESTART_OPTION_LENGTH_INVALID);
        }
    }

    private void isRange(String inputOption) {
        int num = Integer.parseInt(inputOption);
        if (num < RESTART_OPTION_MIN_VALUE || num > RESTART_OPTION_MAX_VALUE) {
            throw new IllegalArgumentException(RESTART_OPTION_RANGE_INVALID);
        }
    }
}