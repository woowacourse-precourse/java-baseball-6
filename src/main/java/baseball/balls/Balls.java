package baseball.balls;

import baseball.validators.BallsValidators;
import baseball.validators.ObjectDistinctValidator;
import java.util.List;
import java.util.stream.Collectors;

public class Balls {

    public static final int BALL_COUNT = 3;

    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        BallsValidators.validateBallCount(balls);
        ObjectDistinctValidator.validateDistinct(values());
        ObjectDistinctValidator.validateDistinct(indexs());
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

    private List<Object> values() {
        return balls.stream()
                .map(Ball::getValue)
                .collect(Collectors.toList());
    }

    private List<Object> indexs() {
        return balls.stream()
                .map(Ball::getIndex)
                .collect(Collectors.toList());
    }

}
