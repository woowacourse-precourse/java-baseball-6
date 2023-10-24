package baseball.model;

import static baseball.util.AppConstants.PERFECT_STRIKES;

public class Score {
    private final int ball;
    private final int strike;

    public Score(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public Score() {
        this(0, 0);
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public boolean isThreeStrikes() {
        return strike == PERFECT_STRIKES;
    }
}