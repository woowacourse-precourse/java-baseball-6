package baseball.domain.ball;

import baseball.domain.result.BallResult;
import baseball.domain.result.GameResult;
import baseball.domain.util.BallsConvertor;
import baseball.domain.util.RandomBallGenerator;

import java.util.List;

public class Balls {
    private final List<Ball> balls;

    public Balls(int number) {
        balls = BallsConvertor.convertNumberToBalls(number);
    }
    public Balls() { balls = RandomBallGenerator.makeBalls(); }

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