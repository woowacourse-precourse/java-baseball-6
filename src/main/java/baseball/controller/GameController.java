package baseball.controller;

import baseball.model.Computer;
import baseball.model.FinishInput;
import baseball.model.GameResultCalculator;
import baseball.model.Number;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {
    private final OutputView view;
    private final InputView input;
    private final GameResultCalculator calculator;
    private Computer computer;
    private Number randomNumber;

    public GameController() {
        view = new OutputView();
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
        computer = new Computer();
        List<Integer> random = computer.getRandomNumber();

        this.randomNumber = new Number(random);
    }

    public void playGame() {
        Number inputNumber;
        do {
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
