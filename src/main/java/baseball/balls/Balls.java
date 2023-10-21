package baseball.balls;

import baseball.utils.BallsUtils;
import baseball.utils.StringUtils;
import baseball.validators.BallsValidators;
import java.util.List;

public class Balls {

    public static final int BALL_COUNT = 3;

    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        BallsValidators.validateBallCount(balls);
        BallsValidators.validateValueDuplication(balls);
        BallsValidators.validateIndexDuplication(balls);
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

}
