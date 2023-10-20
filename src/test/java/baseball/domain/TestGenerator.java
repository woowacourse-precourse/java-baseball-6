package baseball.domain;

import java.util.List;

public class TestGenerator implements BallsGenerator {
    @Override
    public Balls generateBalls() {
        return Balls.from(List.of(1, 2, 3));
    }
}
