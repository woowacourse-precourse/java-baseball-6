package baseball.model;

import static baseball.model.Balls.BALL_SIZE;

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

    public boolean isContinue() {
        return this.strike != BALL_SIZE;
    }

    public boolean hasBall() {
        return this.ball != ZERO;
    }

    public boolean hasStrike() {
        return this.strike != ZERO;
    }

    public boolean isNothing() {
        return !hasBall() && !hasStrike();
    }
}