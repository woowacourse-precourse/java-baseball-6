package baseball.domain;

import java.util.Objects;

public class Score {
    private static final int MIN_COUNT = 0;
    private static final int MAX_COUNT = 3;
    private static final String TOTAL_COUNT_RANGE_EXCEPTION_MESSAGE = "볼과 스트라이크 갯수의 합은 0 이상 3 이하여야 합니다.";
    private final Ball ball;
    private final Strike strike;

    public Score(Ball ball, Strike strike) {
        validateTotalCount(ball, strike);
        this.ball = ball;
        this.strike = strike;
    }

    private static void validateTotalCount(Ball ball, Strike strike) {
        int totalCount = ball.getValue() + strike.getValue();
        if (totalCount < MIN_COUNT || MAX_COUNT < totalCount) {
            throw new IllegalArgumentException(TOTAL_COUNT_RANGE_EXCEPTION_MESSAGE);
        }
    }

    public int getBallCount() {
        return this.ball.getValue();
    }

    public boolean isStrikeOut() {
        return this.strike.isFullCount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Score score)) {
            return false;
        }
        return Objects.equals(ball, score.ball) && Objects.equals(strike, score.strike);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ball, strike);
    }
}
