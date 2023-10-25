package baseball.domain;

import baseball.constant.ErrorMessage;
import baseball.constant.ResultStatus;
import baseball.constant.StrikeBall;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public final class BallCount {

    private static final int BALL_COUNT_SIZE = 3;
    private final List<StrikeBall> values;

    public BallCount(final List<StrikeBall> values) {
        validate(values);
        this.values = Collections.unmodifiableList(values);
    }

    private void validate(final List<StrikeBall> ballCount) {
        if (hasInvalidSize(ballCount)) {
            throw new IllegalStateException(ErrorMessage.INVALID_BALL_COUNT_SIZE.toValue());
        }
    }

    private boolean hasInvalidSize(final List<StrikeBall> ballCount) {
        return ballCount.size() != BALL_COUNT_SIZE;
    }

    public long countStrike() {
        return count(StrikeBall::isStrike);
    }

    public long countBall() {
        return count(StrikeBall::isBall);
    }

    private long count(final Predicate<StrikeBall> predicate) {
        return values.stream().filter(predicate).count();
    }

    public ResultStatus checkResultStatus() {
        if (countStrike() == BALL_COUNT_SIZE) {
            return ResultStatus.SUCCESS;
        }
        return ResultStatus.CONTINUE;
    }
}
