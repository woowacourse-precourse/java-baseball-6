package baseball.model;

public class Score {
    private static final int PERFECT_STRIKES = 3;

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