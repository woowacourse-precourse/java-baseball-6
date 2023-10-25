package baseball.domain;

import baseball.SYSTEM_VALUE.GameStatusValue;

public class Score {
    private int strike = 0;
    private int ball = 0;

    public Score(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isGameOver() {
        return strike == GameStatusValue.GAME_FINISH;
    }

    public boolean isStrike() {
        return strike == 3;
    }

    public boolean isBall() {
        return ball == 4;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }
}
