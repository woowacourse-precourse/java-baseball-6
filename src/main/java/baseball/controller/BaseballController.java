package baseball.controller;

import baseball.service.BaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {
    private final BaseballService baseballService = new BaseballService();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
}
