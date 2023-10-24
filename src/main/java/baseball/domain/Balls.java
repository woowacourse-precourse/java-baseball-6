package baseball.domain;

import java.util.List;
import java.util.Objects;

public class Balls {

    private static final int STRIKE = 0;
    private static final int BALL = 1;
    private static final int NOTHING = 2;

    private final List<Integer> balls;

    public Balls(List<Integer> balls) {
        this.balls = balls;
    }

    public int compare(int ball, int i) {
        if (Objects.equals(balls.get(i), ball)) {
            return STRIKE;
        }
        if (balls.contains(ball)) {
            return BALL;
        }
        return NOTHING;
    }
}
