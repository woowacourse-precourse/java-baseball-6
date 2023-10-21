package baseball.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Balls {

    private static final int BALL_SIZE = 3;

    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        validateSize(balls);
        this.balls = balls;
    }

    private void validateSize(List<Ball> balls) {
        if (balls == null || balls.size() != BALL_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public int countStrike(Balls balls) {
        return getBalls().stream()
                .filter(b -> balls.isStrike(b))
                .collect(Collectors.toList())
                .size();
    }

    private boolean isStrike(Ball ball) {
        return getBalls().stream()
                .anyMatch(b -> b.isStrike(ball));
    }

    private List<Ball> getBalls() {
        return this.balls;
    }
}