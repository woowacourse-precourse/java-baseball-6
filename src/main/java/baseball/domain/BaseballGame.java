package baseball.domain;

import baseball.domain.strategy.BallNumbersGenerateStrategy;
import baseball.view.GameInputView;
import baseball.dto.GuessResult;
import baseball.view.GameOutputView;

public class BaseballGame {

    private final Balls computerBalls;

    private BaseballGame(Balls computerBalls) {
        this.computerBalls = computerBalls;
    }

    public static BaseballGame newGame(BallNumbersGenerateStrategy generateStrategy) {
        return new BaseballGame(Balls.from(generateStrategy.generate()));
    }

    public void play() {
        boolean correct;

        do {
            Balls userBalls = readUserBalls();

            GuessResult guessResult = computerBalls.guess(userBalls);
            GameOutputView.printGuessResult(guessResult);
            correct = guessResult.correct();
        } while (!correct);
    }

    private Balls readUserBalls() {
        GameOutputView.printEnterBallNumbersScript();
        return Balls.from(GameInputView.readBallNumbers());
    }

}
