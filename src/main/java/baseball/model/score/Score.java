package baseball.model.score;

public class Score {
    private static final int THREE_STRIKE = 3;

    private final int ball;
    private final int strike;

    public Score(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public boolean isThreeStrike() {
        return strike == THREE_STRIKE;
    }
}
