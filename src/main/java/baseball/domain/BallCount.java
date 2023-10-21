package baseball.domain;

import baseball.constant.StrikeBall;

import java.util.List;

public class BallCount {

    private static final int BALL_COUNT_SIZE = 3;
    private final List<StrikeBall> ballCount;

    public BallCount(final List<StrikeBall> ballCount) {
        validate(ballCount);
        this.ballCount = ballCount;
    }

    private void validate(final List<StrikeBall> ballCount) {
        if (hasInvalidSize(ballCount)) {
            throw new IllegalStateException();
        }
    }

    private boolean hasInvalidSize(final List<StrikeBall> ballCount) {
        return ballCount.size() != BALL_COUNT_SIZE;
    }
}
