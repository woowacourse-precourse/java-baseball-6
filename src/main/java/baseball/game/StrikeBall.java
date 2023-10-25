package baseball.game;

import baseball.common.Constants;

public class StrikeBall {
    private int strike;
    private int ball;

    public StrikeBall(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isNoting() {
        return this.strike == 0 && this.ball == 0;
    }

    public boolean hasBallCount() {
        return this.ball > 0;
    }

    public boolean hasStrikeCount() {
        return this.strike > 0;
    }

    public boolean isStrikeSuccess() {
        return this.strike == Constants.strikeTarget;
    }
}