package baseball.controller;

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
        return inputView.numberInput();
    }

    public int restartNumberInput() {
        return inputView.restartInput();
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

