package baseball.model;

import baseball.Setting;

public class PlayResult {

    public static final int ZERO = 0;
    private static final int BALL_SIZE = Setting.BALL_SIZE.get();
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
}