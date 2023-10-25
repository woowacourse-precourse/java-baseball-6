package baseball.controller;

import baseball.service.BaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BaseballService baseballService;

    public BaseballGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.baseballService = new BaseballService();

    }

    public void greet() {
        outputView.printGreet();
    }
}
