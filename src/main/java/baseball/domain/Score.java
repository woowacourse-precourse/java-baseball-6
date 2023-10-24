package baseball.domain;


import java.util.Arrays;

public enum Score {
    NO_BALL_NO_STRIKE(Ball.from(0), Strike.from(0)),
    NO_BALL_ONE_STRIKE(Ball.from(0), Strike.from(1)),
    NO_BALL_TWO_STRIKE(Ball.from(0), Strike.from(2)),
    NO_BALL_THREE_STRIKE(Ball.from(0), Strike.from(3)),
    ONE_BALL_NO_STRIKE(Ball.from(1), Strike.from(0)),
    TWO_BALL_NO_STRIKE(Ball.from(2), Strike.from(0)),
    THREE_BALL_NO_STRIKE(Ball.from(3), Strike.from(0)),
    ONE_BALL_ONE_STRIKE(Ball.from(1), Strike.from(1)),
    ONE_BALL_TWO_STRIKE(Ball.from(1), Strike.from(2)),
    TWO_BALL_ONE_STRIKE(Ball.from(2), Strike.from(1));

    private static final String TOTAL_COUNT_RANGE_EXCEPTION_MESSAGE = "볼과 스트라이크 갯수의 합은 0 이상 3 이하여야 합니다.";
    public static final String NOTHING = "낫싱";
    public static final String SPACE = " ";
    private final Ball ball;
    private final Strike strike;

    Score(Ball ball, Strike strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public static Score from(Ball ball, Strike strike) {
        return Arrays.stream(values())
                .filter(score -> score.ball.equals(ball) && score.strike.equals(strike))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(TOTAL_COUNT_RANGE_EXCEPTION_MESSAGE));
    }

    public boolean isStrikeOut() {
        return this.strike.isFullCount();
    }

    @Override
    public String toString() {
        boolean isZeroBall = this.ball.isEmpty();
        boolean isZeroStrike = this.strike.isEmpty();
        if (isZeroBall && isZeroStrike) {
            return NOTHING;
        }
        if (isZeroBall) {
            return this.strike.toString();
        }
        if (isZeroStrike) {
            return this.ball.toString();
        }
        return this.ball + SPACE + this.strike;
    }
}
