package baseball.application;

public class BaseBallResult {

    private final int strike;
    private final int ball;

    public BaseBallResult(int strike, int ball) {
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
