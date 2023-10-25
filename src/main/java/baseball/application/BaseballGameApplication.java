package baseball.application;

import baseball.controller.BaseballController;
import baseball.service.ScoreCalculator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameApplication {

    private final ScoreCalculator scoreCalculator;
    private final InputView inputView;
    private final OutputView outputView;

    public BaseballGameApplication() {
        this.scoreCalculator = new ScoreCalculator();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        BaseballController baseballController = new BaseballController(scoreCalculator, inputView, outputView);
        baseballController.run();
    }
}
