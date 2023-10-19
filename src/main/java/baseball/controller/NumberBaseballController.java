package baseball.controller;

import baseball.model.NumberBaseball;
import baseball.view.InputView;
import baseball.view.OutputView;

public class NumberBaseballController {
    private final InputView inputView;
    private final OutputView outputView;

    public NumberBaseballController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        NumberBaseball numberBaseball = new NumberBaseball();
        inputView.showGameStartMent();
    }

}
