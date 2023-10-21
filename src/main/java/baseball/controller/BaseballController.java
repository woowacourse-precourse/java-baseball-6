package baseball.controller;

import baseball.io.OutputView;
import baseball.service.BaseballService;

public class BaseballController {

    private final OutputView outputView;
    private final BaseballService baseballService;

    public BaseballController(final OutputView outputView, final BaseballService baseballService) {
        this.outputView = outputView;
        this.baseballService = baseballService;
    }

    public void run() {
        outputView.printStartMessage();
        play();
    }

    private void play() {
        baseballService.saveRandomNumbers();
    }
}
