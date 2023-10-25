package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

record Ball(List<Integer> balls) {
    private static final Integer MIN_NUM = 1;
    private static final Integer MAX_NUM = 9;

    Ball {
        validateDuplicate(balls);
        validateSize(balls);
        validateRange(balls);
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
