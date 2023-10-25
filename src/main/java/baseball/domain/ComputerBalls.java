package baseball.domain;

import baseball.domain.strategy.BallNumbersGenerateStrategy;
import baseball.dto.GuessResult;
import java.util.List;

public class ComputerBalls extends AbstractBalls {

    private ComputerBalls(List<Ball> balls) {
        super(balls);
    }

    public static ComputerBalls from(BallNumbersGenerateStrategy generateStrategy) {
        String ballNumbers = generateStrategy.generate(Ball.MINIMUM_VALID_NUMBER, Ball.MAXIMUM_VALID_NUMBER,
                VALID_BALL_COUNT);
        return new ComputerBalls(mapToBalls(ballNumbers));
    }

    public GuessResult guess(Balls otherBalls) {
        GuessResult guessResult = GuessResult.empty();

        for (int otherBallIndex = 0; otherBallIndex < VALID_BALL_COUNT; otherBallIndex++) {
            BallStatus ballStatus = compare(otherBallIndex, otherBalls.ballAt(otherBallIndex));
            guessResult.add(ballStatus);
        }

        return guessResult;
    }

    private BallStatus compare(int otherBallIndex, Ball otherBall) {
        if (this.ballAt(otherBallIndex).equals(otherBall)) {
            return BallStatus.STRIKE;
        }

        return balls().stream()
                .filter(thisBall -> thisBall.equals(otherBall))
                .findAny()
                .map(thisBall -> BallStatus.BALL)
                .orElse(BallStatus.NONE);
    }

}
