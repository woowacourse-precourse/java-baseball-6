package baseball;

public class BallResult {
    int ball;
    int strike;

    public BallResult(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
