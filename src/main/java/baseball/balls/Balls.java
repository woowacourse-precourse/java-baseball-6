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

    public static Balls fromIntegers(List<Integer> integers) {
        List<Ball> balls = BallsUtils.convertIntegersToBallList(integers);
        return new Balls(balls);
    }

    public static Balls fromString(String string) {
        List<Integer> integers = StringUtils.convertStringToIntegerList(string);
        return fromIntegers(integers);
    }

    public boolean hasSameValueBall(Ball anotherBall) {
        return balls.stream()
                .anyMatch(ball -> ball.hasSameValue(anotherBall));
    }

    public boolean hasSameBall(Ball anotherBall) {
        return balls.stream()
                .anyMatch(ball -> ball.equals(anotherBall));
    }

}
