package baseball.domain.ball;

import baseball.domain.result.BallResult;
import baseball.domain.result.GameResult;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> balls;

    public Balls(Ball ball1, Ball ball2, Ball ball3) {
        this.balls = new ArrayList<>();
        balls.add(ball1);
        balls.add(ball2);
        balls.add(ball3);
    }

    public GameResult compareWithBalls(Balls otherBalls) {
        GameResult gameResult = new GameResult();
        balls.stream()
                .map(otherBalls::compareWithBall)
                .forEach(gameResult::update);
        return gameResult;
    }

    BallResult compareWithBall(Ball otherBall) {
        return balls.stream().map(ball -> ball.compareBall(otherBall))
                .max(BallResult::compare)
                .orElse(BallResult.NOTHING);
    }
}