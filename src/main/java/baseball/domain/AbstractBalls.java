package baseball.domain;

import java.util.Collections;
import java.util.List;

public abstract class AbstractBalls implements Balls {

    private final List<Ball> balls;

    protected AbstractBalls(List<Ball> balls) {
        this.balls = balls;
    }

    @Override
    public List<Ball> balls() {
        return Collections.unmodifiableList(balls);
    }

    @Override
    public Ball ballAt(int index) {
        return balls.get(index);
    }

    @Override
    public String toString() {
        return "Balls{" +
                "balls=" + balls +
                '}';
    }

}
