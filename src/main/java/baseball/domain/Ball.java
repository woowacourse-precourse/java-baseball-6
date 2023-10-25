package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Ball {
    private static final Integer MIN_NUM = 1;
    private static final Integer MAX_NUM = 9;
    private final List<Integer> balls;

    Ball(List<Integer> balls) {
        validateDuplicate(balls);
        validateSize(balls);
        validateRange(balls);
        this.balls = balls;
    }

    private void validateSize(List<Integer> balls) {
        if (balls.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> balls) {
        Set<Integer> set = new HashSet<>();
        for (Integer ball : balls) {
            if (!set.add(ball)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateRange(List<Integer> balls) {
        for (Integer ball : balls) {
            if (ball < MIN_NUM || ball > MAX_NUM) {
                throw new IllegalArgumentException();
            }
        }
    }
}
