package baseball.common;

public class CheckResult {
    private int strike;
    private int ball;

    public CheckResult(int strike, int ball) {
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
