package baseball.domain;

public class BallHint {

    private int strike;
    private int ball;

    public boolean isNothing() {
        return strike + ball == 0;
    }

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    public void resetHint() {
        this.strike = 0;
        this.ball = 0;
    }
}
