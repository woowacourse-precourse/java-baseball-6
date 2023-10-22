package baseball.controller;

import baseball.model.GameInput;
import baseball.model.GameResultCalculator;
import baseball.model.Number;
import baseball.model.RandomNumberGenerator;
import baseball.view.GameView;
import java.util.List;

public class GameController {
    private final RandomNumberGenerator randomNumberGenerator;
    private final GameView view;
    private final GameInput input;
    private final GameResultCalculator calculator;
    private Number randomNumber;

    public GameController() {
        randomNumberGenerator = new RandomNumberGenerator();
        view = new GameView();
        input = new GameInput();
        calculator = new GameResultCalculator();
    }

    public void start() {
        while (!isEnd()) {
            startGame();
            playGame();
            endGame();
        }
    }


    public void startGame() {
        view.printStartMessage();
        List<Integer> random = randomNumberGenerator.generateRandomNumber();
        this.randomNumber = new Number(random);
    }

    public void playGame() {
        Number inputNumber;
        do {
            view.printAskInputMessage();
            inputNumber = input.readNumberInput();

            int ballCount = calculator.countBall(randomNumber, inputNumber);
            int strikeCount = calculator.countStrike(randomNumber, inputNumber);

            if (strikeCount == 0 && ballCount == 0) {
                view.printResultNothing();
            }

            if (ballCount != 0) {
                view.printResultBall(ballCount);
            }

            if (strikeCount != 0) {
                view.printResultStrike(strikeCount);
            }

        } while (!calculator.isThreeStrike(randomNumber, inputNumber));

    }


    public void endGame() {
        view.printSuccessAndEndMessage();

    }

    private boolean isEnd() {
        return true;
    }

}
