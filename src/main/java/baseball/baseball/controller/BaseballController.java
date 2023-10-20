package baseball.baseball.controller;

import baseball.baseball.model.BaseballService;
import baseball.baseball.util.StringConvertUtil;
import baseball.baseball.view.InputView;
import baseball.baseball.view.OutputView;

import java.util.List;

public class BaseballController {
    private static final BaseballService baseballService = new BaseballService();
    private static final OutputView outputView = OutputView.getInstance();
    private static final InputView inputView = InputView.getInstance();
    private static List<Integer> goalNumber;

    public void run() {
        start();
    }

    private void start() {
        outputView.printStartGame();
        goalNumber = baseballService.createGoalNumber();
    }
}
