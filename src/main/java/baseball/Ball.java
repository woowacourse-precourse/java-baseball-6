package baseball.computer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ball {
    private static final int BALLS_SIZE = 3;
    private List<Integer> balls;

    public Ball(List<Integer> balls) {
        validateSize(balls);
        validateDuplicateBall(balls);

        this.balls = balls;
    }

    private void validateSize(List<Integer> balls) {
        if (balls.size() != BALLS_SIZE) {
            throw new IllegalArgumentException("볼의 개수는 3개만 가능합니다.");
        }
    }

    private void validateDuplicateBall(List<Integer> balls) {
        Set<Integer> ballsToSet = new HashSet<>(balls);
        if (ballsToSet.size() != BALLS_SIZE) {
            throw new IllegalArgumentException("중복된 볼은 허용하지 않습니다.");
        }
    }
}
