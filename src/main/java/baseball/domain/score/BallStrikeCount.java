package baseball.domain.score;

public class BallStrikeCount {

    private static final int EMPTY = 0;

    private int ball;
    private int strike;

    private BallStrikeCount(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public static BallStrikeCount initial() {
        return new BallStrikeCount(EMPTY, EMPTY);
    }

    public void countBall() {
        ball++;
    }

    public void countStrike() {
        strike++;
    }

    public ImmutableBallStrikeCount toImmutable() {
        return ImmutableBallStrikeCount.of(ball, strike);
    }
}
