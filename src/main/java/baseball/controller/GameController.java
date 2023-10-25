package baseball.controller;

import baseball.model.Computer;
import baseball.model.FinishInput;
import baseball.model.GameResult;
import baseball.model.Number;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private final OutputView view;
    private final InputView input;
    private final GameResult calculator;
    private Computer computer;
    private Number randomNumber;

    public GameController() {
        view = new OutputView();
        input = new InputView();
        calculator = new GameResult();
        computer = new Computer();
    }

    public void start() {
        view.printStartMessage();
        do {
            startGame();
            playGame();
        } while (!isEndGame());
    }


    private void startGame() {
        computer.generateRandomNumber();
        this.randomNumber = new Number(computer.getRandomNumber());
    }

    private void playGame() {
        Number inputNumber;
        do {
            inputNumber = input.readNumberInput();

            calculator.makeGameResult(randomNumber, inputNumber);

            view.printGameResult(calculator.toString());

        } while (!calculator.isThreeStrike());

    }

    private boolean isEndGame() {
        view.printSuccessAndEndMessage();
        FinishInput finishInput = input.readFinishInput();

        return finishInput == FinishInput.END_GAME;
    }

}
