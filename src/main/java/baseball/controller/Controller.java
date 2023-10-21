package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;

public final class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final Service service;

    public Controller(InputView inputView, OutputView outputView, Service service) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.service = service;
    }

    public void run() {
        createAnswerNumber();
    }

    private void createAnswerNumber() {
        createAnswerNumber();
    }

}
