package baseball.model.service;

import static baseball.model.constants.Constant.RESTART_MAX_VALUE;
import static baseball.model.constants.Constant.RESTART_MIN_VALUE;
import static baseball.model.constants.Constant.RESTART_SIZE;
import static baseball.model.constants.ExceptionMessage.RESTART_LENGTH_IS_WRONG;
import static baseball.model.constants.ExceptionMessage.RESTART_NOT_NUMBER;
import static baseball.model.constants.ExceptionMessage.RESTART_RANGE_IS_WRONG;

public class RestartNumberImpl implements RestartNumber {
    @Override
    public void isNonNumber(String inputNumber) {
        for (int i = 0; i < inputNumber.length(); i++) {
            if (!Character.isDigit(inputNumber.charAt(i))) {
                throw new IllegalArgumentException(RESTART_NOT_NUMBER);
            }
        }
    }

    @Override
    public void isLengthCorrect(String inputNumber) {
        if (inputNumber.length() != RESTART_SIZE) {
            throw new IllegalArgumentException(RESTART_LENGTH_IS_WRONG);
        }
    }

    @Override
    public void isRange(Integer convertNumber) {
        if (convertNumber < RESTART_MIN_VALUE || convertNumber > RESTART_MAX_VALUE) {
            throw new IllegalArgumentException(RESTART_RANGE_IS_WRONG);
        }
    }
}