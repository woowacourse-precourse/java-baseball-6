package baseball.domain.balls;

import baseball.domain.results.ResultStatus;
import baseball.dto.BallsDifferenceDto;
import baseball.validator.ListValidators;
import java.util.List;

public class Balls {

    private static final int BALL_COUNT = 3;

    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        validateSize(balls);
        validateDistinctValue(balls);
        validateDistinctIndex(balls);
        this.balls = balls;
    }

    private void validateSize(List<Ball> balls) {
        ListValidators.validateSize(balls, BALL_COUNT);
    }

    private void validateDistinctValue(List<Ball> balls) {
        ListValidators.validateDistinct(
                balls.stream()
                        .map(Ball::getValue)
                        .toList()
        );
    }

    private void validateDistinctIndex(List<Ball> balls) {
        ListValidators.validateDistinct(
                balls.stream()
                        .map(Ball::getIndex)
                        .toList());
    }

    public boolean hasSameValueBall(Ball anotherBall) {
        return balls.stream()
                .anyMatch(ball -> ball.hasSameValue(anotherBall));
    }

    public boolean hasSameBall(Ball anotherBall) {
        return balls.stream()
                .anyMatch(ball -> ball.equals(anotherBall));
    }

    public BallsDifferenceDto getDifference(Balls anotherBalls) {
        int sameBallCount = (int) balls.stream()
                .filter(anotherBalls::hasSameBall)
                .count();
        int sameValueBallCount = (int) balls.stream()
                .filter(anotherBalls::hasSameValueBall)
                .count() - sameBallCount;
        int differentBallCount = BALL_COUNT - sameBallCount - sameValueBallCount;

        return new BallsDifferenceDto(sameBallCount, sameValueBallCount, differentBallCount);
    }

}
