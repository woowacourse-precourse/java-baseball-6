package baseball.controller;

import baseball.exception.InputException;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;

public class IOController {
    private final InputView inputView;
    private final OutputView outputView;

    public IOController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public ArrayList<Integer> inningNumberInput() {
        ArrayList<Integer> numberInput = inputView.numberInput();
        InputException.validateInput(numberInput);
        return numberInput;
    }

    public int restartNumberInput() {
        int restartNumber = inputView.restartInput();
        InputException.validateRestartInput(restartNumber);
        return restartNumber;
    }

    public void gameStartNotify() {
        outputView.gameStart();
    }

    public void gameEndNotify() {
        outputView.gameEnd();
    }

    public void showResult(String result) {
        outputView.numberResult(result);
    }
}

