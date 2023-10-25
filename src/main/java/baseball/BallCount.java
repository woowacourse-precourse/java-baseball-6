package baseball;

public class BallCount {
    private int strike;
    private int ball;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public BallCount() {
    }

    public BallCount(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }
}
