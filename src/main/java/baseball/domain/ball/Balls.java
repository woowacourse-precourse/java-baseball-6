package baseball.domain.ball;

import baseball.domain.result.BallResult;
import baseball.domain.result.GameResult;
import baseball.domain.util.BallsConvertor;
import baseball.domain.util.RandomBallGenerator;

import java.util.List;

public class Balls {
    private static final String WRONG_NUMBER_SIZE_MESSAGE = "세자리 숫자를 입력해야 합니다.";
    private static final int MIN_BALL_NUMBER = 100;
    private static final int MAX_BALL_NUMBER = 999;

    private final List<Ball> balls;

    public Balls(int number) {
        validator(number);
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

    private void validator(int number) {
        if (number < MIN_BALL_NUMBER || number > MAX_BALL_NUMBER) {
            throw new IllegalArgumentException(WRONG_NUMBER_SIZE_MESSAGE);
        }
    }
}