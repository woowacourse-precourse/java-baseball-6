package baseball.controller;

import baseball.service.NumberBaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;


public class GameManager {
    private InputView inputView;
    private OutputView outputView;
    private NumberBaseballService numberBaseballService;

    public GameManager(InputView inputView, OutputView outputView, NumberBaseballService numberBaseballService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberBaseballService = numberBaseballService;
    }

}
