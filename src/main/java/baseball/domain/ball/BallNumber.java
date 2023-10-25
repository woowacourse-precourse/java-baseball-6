package baseball.domain.ball;

import baseball.exception.InvalidBallNumberRangeException;

public record BallNumber(
        int number
) {
    private static final int MIN_BALL_NUMBER = 1;

    private static final int MAX_BALL_NUMBER = 9;

    public BallNumber {
        if (number < MIN_BALL_NUMBER || number > MAX_BALL_NUMBER) {
            throw new InvalidBallNumberRangeException();
        }
    }

}
