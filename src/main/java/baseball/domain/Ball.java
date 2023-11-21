package baseball.domain;

import baseball.exception.ErrorMessage;
import baseball.exception.InvalidRangeException;
import baseball.global.Const;

public class Ball {
    private final Integer number;

    private Ball(Integer number) {
        validateRange(number);
        this.number = number;
    }

    public static Ball createOf(int number) {
        return new Ball(number);
    }

    private void validateRange(int number) {
        if (isNotRequiredRange(number)) {
            throw InvalidRangeException.of(ErrorMessage.NOT_REQUIRED_RANGE);
        }
    }

    private boolean isNotRequiredRange(int number) {
        return number < Const.MINIMUM_VALUE || number > Const.MAXIMUM_VALUE;
    }
}
