package baseball.model.service;

import static baseball.model.constants.ExceptionMessages.RESTART_OPTION_LENGTH_INVALID;
import static baseball.model.constants.ExceptionMessages.RESTART_OPTION_NON_NUMBER;
import static baseball.model.constants.ExceptionMessages.RESTART_OPTION_RANGE_INVALID;
import static baseball.model.constants.GameConstants.RESTART_OPTION_MAX_VALUE;
import static baseball.model.constants.GameConstants.RESTART_OPTION_MIN_VALUE;
import static baseball.model.constants.GameConstants.RESTART_OPTION_SIZE;

public class RestartOptionValidatorImp implements RestartOptionValidator {
    @Override
    public void isNonNumber(String inputOption) {
        for (int i = 0; i < inputOption.length(); i++) {
            if (!Character.isDigit(inputOption.charAt(i))) {
                throw new IllegalArgumentException(RESTART_OPTION_NON_NUMBER);
            }
        }
    }

    @Override
    public void isLengthCorrect(String inputOption) {
        if (inputOption.length() != RESTART_OPTION_SIZE) {
            throw new IllegalArgumentException(RESTART_OPTION_LENGTH_INVALID);
        }
    }

    @Override
    public void isRange(Integer convertOption) {
        if (convertOption < RESTART_OPTION_MIN_VALUE || convertOption > RESTART_OPTION_MAX_VALUE) {
            throw new IllegalArgumentException(RESTART_OPTION_RANGE_INVALID);
        }
    }
}