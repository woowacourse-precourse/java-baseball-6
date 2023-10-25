package baseball.model;

import baseball.ExceptionMessage;
import baseball.GameMessage;

public class BallNumber {
    private Integer number;

    public BallNumber(Integer number) {
        validateBallNumberRange(number);
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    private void validateBallNumberRange(Integer number) {
        if (number < GameMessage.MIN_NUMBER.getNumber() || number > GameMessage.MAX_NUMBER.getNumber()) {
            throw new IllegalArgumentException(ExceptionMessage.ILLEGAL_BASEBALL_NUMBER_RANGE_MESSAGE.getMessage());
        }
    }
}
