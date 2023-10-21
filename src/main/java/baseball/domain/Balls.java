package baseball.domain;

import java.util.List;

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
}