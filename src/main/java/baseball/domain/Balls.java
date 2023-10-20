package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.domain.Ball.*;

public class Balls {
    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        validate(balls);
        this.balls = List.copyOf(balls);
    }

    public boolean containsBall(Ball otherBall) {
        for (Ball ball : balls) {
            if (ball.getNumber().equals(otherBall.getNumber())) {
                return true;
            }
        }
        return false;
    }
    public Ball getBall(int index) {
        return balls.get(index);
    }

    private void validate(List<Ball> balls) {
        validateNumeric(balls);
        validateNumberOfBalls(balls);
        validateDuplicates(balls);
    }

    private void validateNumeric(List<Ball> balls) {
        if (balls == null) {
            throwIllegalArgumentException(); // NullPointerException 이 좋아보임
        }

        for (Ball ball : balls) {
            if (ball.getNumber() == null || ball.getNumber() < MIN_BALL || ball.getNumber() > MAX_BALL) {
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
            if (!set.add(ball.getNumber())) {
                throwIllegalArgumentException();
            }
        }
    }

    private void throwIllegalArgumentException() {
        throw new IllegalArgumentException("입력한 숫자는 1에서 9 사이의 중복되지 않는 3자리여야 합니다.");
    }
}
