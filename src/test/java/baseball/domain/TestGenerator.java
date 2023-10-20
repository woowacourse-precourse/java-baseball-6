package baseball.domain;

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
