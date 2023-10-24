package baseball.controller;

import baseball.model.FinishInput;
import baseball.model.GameResultCalculator;
import baseball.model.Number;
import baseball.model.RandomNumberGenerator;
import baseball.view.GameView;
import baseball.view.InputView;
import java.util.List;

public class GameController {
    private final RandomNumberGenerator randomNumberGenerator;
    private final GameView view;
    private final InputView input;
    private final GameResultCalculator calculator;
    private Number randomNumber;

    public GameController() {
        randomNumberGenerator = new RandomNumberGenerator();
        view = new GameView();
        input = new InputView();
        calculator = new GameResultCalculator();
    }

    public void start() {
        view.printStartMessage();
        do {
            startGame();
            playGame();
        } while (!isEndGame());
    }


    public void startGame() {
        List<Integer> random = randomNumberGenerator.generateRandomNumber();
        this.randomNumber = new Number(random);
    }

    public void playGame() {
        Number inputNumber;
        do {
            view.printAskInputMessage();
            inputNumber = input.readNumberInput();

            String result = calculator.makeGameResult(randomNumber, inputNumber);
            view.printGameResult(result);

        } while (!calculator.isThreeStrike(randomNumber, inputNumber));

    }

    public boolean isEndGame() {
        view.printSuccessAndEndMessage();
        FinishInput finishInput = input.readFinishInput();

        return finishInput == FinishInput.END_GAME;
    }

}
