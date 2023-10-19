package baseball.domain;

import java.util.List;

import static baseball.exception.ExceptionMessage.BallException.BALL_IS_NOT_IN_RANGE;

public class Baseball {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;
    private static final int TOTAL_SIZE = 3;

    private final List<Integer> balls;

    private Baseball(final List<Integer> balls) {
        this.balls = balls;
    }

    public static Baseball of(final List<Integer> balls) {
        validateBallRange(balls);
        return new Baseball(balls);
    }

    private static void validateBallRange(final List<Integer> balls) {
        if (hasOutOfRange(balls)) {
            throw new IllegalArgumentException(BALL_IS_NOT_IN_RANGE.message);
        }
    }

    private static boolean hasOutOfRange(final List<Integer> balls) {
        return balls.stream()
                .anyMatch(ball -> ball < MIN_VALUE || ball > MAX_VALUE);
    }
}
