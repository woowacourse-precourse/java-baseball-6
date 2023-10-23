package baseball.model;

public class PlayResult {

    public static final int ZERO = 0;
    private int ball = ZERO;
    private int strike = ZERO;

    public int getBall() {
        return this.ball;
    }

    public int getStrike() {
        return this.strike;
    }

    public void report(BallStatus status) {
        if (status.isBall()) this.ball++;
        if (status.isStrike()) this.strike++;
    }
}