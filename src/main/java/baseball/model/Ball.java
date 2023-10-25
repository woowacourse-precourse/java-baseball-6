package baseball.model;

import java.util.List;
import java.util.stream.IntStream;

import static baseball.exception.ErrorMessage.INVALID_BALL_NUMBER;

public class Ball {
    public static final int START_RANGE = 1;
    public static final int END_RANGE = 9;
    private int num;

    public Ball(int num) {
        if (!isInRange(num)) {
            throw new IllegalArgumentException(INVALID_BALL_NUMBER.toString());
        }
        this.num = num;
    }

    private static boolean isInRange(int num) {
        return START_RANGE <= num && num <= END_RANGE;
    }

    public int getNum() {
        return num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball ball)) return false;

        return getNum() == ball.getNum();
    }

    @Override
    public int hashCode() {
        return getNum();
    }

    public List<BallStatus> checkBalls(int thisIndex, Balls targetBalls) {
        return IntStream.range(0, targetBalls.size())
                .mapToObj((targetIndex) ->
                {
                    Ball targetBall = targetBalls.getBall(targetIndex);
                    return this.checkBall(targetBall, thisIndex, targetIndex);
                })
                .toList();
    }

    private BallStatus checkBall(Ball targetBall, int thisIndex, int targetIndex) {
        if (this.equals(targetBall) && thisIndex == targetIndex) {
            return BallStatus.STRIKE;
        }

        if (this.equals(targetBall) && thisIndex != targetIndex) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

}
