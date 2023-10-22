package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.domain.Ball.*;

public record Balls (List<Ball> balls) {
    private static final String ERROR_MESSAGE = "입력한 숫자는 1에서 9 사이의 중복되지 않는 3자리여야 합니다.";

    public Balls(List<Ball> balls) {
        validate(balls);
        this.balls = List.copyOf(balls);
    }

    public Ball getBall(int index) {
        return balls.get(index);
    }

    public boolean containsOtherBall(Ball otherBall) {
        for (Ball ball : balls) {
            if (ball.number().equals(otherBall.number())) {
                return true;
            }
        }
        return false;
    }

    private void validate(List<Ball> balls) {
        validateNotNullAndNotEmpty(balls);
        validateNumeric(balls);
        validateNumberOfBalls(balls);
        validateDuplicates(balls);
    }

    private void validateNotNullAndNotEmpty(List<Ball> balls) {
        if (balls == null || balls.isEmpty()) {
            throwIllegalArgumentException();
        }
    }

    private void validateNumeric(List<Ball> balls) {
        for (Ball ball : balls) {
            if (ball.number() == null || ball.number() < MIN_BALL || ball.number() > MAX_BALL) {
                throwIllegalArgumentException();
            }
        }
    }

    private void validateNumberOfBalls(List<Ball> balls) {
        if (balls.size() != BALL_SIZE) {
            throwIllegalArgumentException();
        }
    }

    private void validateDuplicates(List<Ball> balls) {
        Set<Integer> set = new HashSet<>();
        for (Ball ball : balls) {
            if (!set.add(ball.number())) {
                throwIllegalArgumentException();
            }
        }
    }

    private void throwIllegalArgumentException() {
        throw new IllegalArgumentException(ERROR_MESSAGE);
    }
}
