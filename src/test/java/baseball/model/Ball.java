package baseball.model;

public class Ball {
    private final int digit;
    private final int value;

    public Ball(int digit, int value) {
        this.digit = digit;
        this.value = value;
    }

    public GameResult compare(Ball computerBall) {
        if (isSameDigit(computerBall) && isSameValue(computerBall)) {
            return GameResult.STRIKE;
        }

        if (isSameValue(computerBall)) {
            return GameResult.BALL;
        }

        return GameResult.NOTHING;
    }

    private boolean isSameValue(Ball computerBall) {
        return value == computerBall.value;
    }

    private boolean isSameDigit(Ball computerBall) {
        return digit == computerBall.digit;
    }
}
