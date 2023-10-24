package baseball.domain;

import baseball.domain.balls.Balls;
import baseball.domain.balls.BallsGenerator;

public class TestGenerator implements BallsGenerator {
    private final Balls balls;

    public TestGenerator(Balls balls) {
        this.balls = balls;
    }

    @Override
    public Balls generateBalls() {
        return balls;
    }
}
