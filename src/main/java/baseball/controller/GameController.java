package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {

    private InputView inputView;
    private OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void playGame() {
        List<Integer> inputNumber = inputView.getInputNumber();
    }
}
