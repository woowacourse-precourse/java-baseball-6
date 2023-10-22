package baseball.domain;

import baseball.config.Config;

public class Result {
    private int ball;
    private int strike;

    public Result(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public boolean hasOnlyBalls() {
        return hasBalls() && !hasStrikes();
    }

    private boolean hasStrikes() {
        return getStrike() > 0;
    }

    private boolean hasBalls() {
        return getBall() > 0;
    }

    public boolean hasOnlyStrikes() {
        return !hasBalls() && hasStrikes();
    }

    public boolean hasBallsAndStrikes() {
        return hasBalls() && hasStrikes();
    }

    public boolean isAllStrikes() {
        return getStrike() == Config.getMaxNumbers();
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }


}
