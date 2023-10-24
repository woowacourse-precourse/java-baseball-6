package baseball.domain;

import baseball.domain.strategy.BallNumbersGenerateStrategy;

public class BaseballGame {

    private final Balls computerBalls;

    private BaseballGame(Balls computerBalls) {
        this.computerBalls = computerBalls;
    }

    public static BaseballGame newGame(BallNumbersGenerateStrategy generateStrategy) {
        return new BaseballGame(Balls.from(generateStrategy.generate()));
    }

}
