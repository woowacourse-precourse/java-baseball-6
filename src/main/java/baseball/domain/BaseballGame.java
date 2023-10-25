package baseball.domain;

import baseball.domain.strategy.BallNumbersGenerateStrategy;
import baseball.view.input.GameInputView;
import baseball.view.output.GameOutputView;

public class BaseballGame {

    private final ComputerBalls computerBalls;

    private BaseballGame(ComputerBalls computerBalls) {
        this.computerBalls = computerBalls;
    }

    public static BaseballGame newGame(BallNumbersGenerateStrategy generateStrategy) {
        return new BaseballGame(ComputerBalls.from(generateStrategy));
    }

    public void play() {
        boolean correct;

        do {
            UserBalls userBalls = readUserBalls();

            GuessResult guessResult = computerBalls.guess(userBalls);
            GameOutputView.printGuessResult(guessResult);
            correct = guessResult.correct();
        } while (!correct);
    }

    private UserBalls readUserBalls() {
        GameOutputView.printEnterBallNumbersScript();
        return UserBalls.from(GameInputView.readBallNumbers());
    }

    public ComputerBalls computerBalls() {
        return computerBalls;
    }

}
