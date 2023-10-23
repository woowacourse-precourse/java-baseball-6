package baseball.model;

public class BallCount {

    private final int strike;
    private final int ball;

    public BallCount(final int strike, final int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
