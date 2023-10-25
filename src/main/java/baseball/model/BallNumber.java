package baseball.model;

import baseball.ExceptionMessage;
import baseball.GameMessage;

public class BallNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private int number;

    public BallNumber(int number) {
        validateBallNumberRange(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validateBallNumberRange(Integer number) {
        if (number < GameMessage.MIN_NUMBER.getNumber() || number > GameMessage.MAX_NUMBER.getNumber()) {
            throw new IllegalArgumentException(ExceptionMessage.ILLEGAL_BASEBALL_NUMBER_RANGE_MESSAGE.getMessage());
        }
    }
}
