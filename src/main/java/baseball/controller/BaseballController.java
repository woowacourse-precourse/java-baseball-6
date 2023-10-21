package baseball.controller;

import baseball.io.InputManager;
import baseball.io.OutputView;
import baseball.service.BaseballService;

public class BaseballController {

    private final OutputView outputView;
    private final InputManager inputManager;
    private final BaseballService baseballService;

    public BaseballController(
            final OutputView outputView,
            final InputManager inputManager,
            final BaseballService baseballService) {
        this.outputView = outputView;
        this.inputManager = inputManager;
        this.baseballService = baseballService;
    }

    public void run() {
        outputView.printStartMessage();
        play();
    }

    private void play() {
        baseballService.saveRandomNumbers();
        outputView.printNumberInputRequest();
        inputManager.readAttemptNumbers();
    }
}
