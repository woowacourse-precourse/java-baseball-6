package baseball.balls;

import baseball.validators.BallsValidators;
import baseball.validators.ListValidators;
import java.util.List;

public class Balls {

    public static final int BALL_COUNT = 3;

    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        BallsValidators.validateBallCount(balls);
        ListValidators.validateDistinct(values());
        ListValidators.validateDistinct(indexs());
        this.balls = balls;
    }

    public boolean hasSameValueBall(Ball anotherBall) {
        return balls.stream()
                .anyMatch(ball -> ball.hasSameValue(anotherBall));
    }

    public boolean hasSameBall(Ball anotherBall) {
        return balls.stream()
                .anyMatch(ball -> ball.equals(anotherBall));
    }

    public List<Ball> getBalls() {
        return balls;
    }

    private List<BallValue> values() {
        return balls.stream()
                .map(Ball::getValue)
                .toList();
    }

    private List<BallIndex> indexs() {
        return balls.stream()
                .map(Ball::getIndex)
                .toList();
    }

}
