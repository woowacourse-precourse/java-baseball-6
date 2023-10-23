package baseball.controller;

import baseball.service.NumberBaseballService;
import baseball.validation.InputValidator;
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

    public void startGame() {
        outputView.printStartMessage();

        numberBaseballService.generateComputerNumbers();

        boolean isCompleted = false;

        while (!isCompleted) {
            String playerNumber = inputView.enterPlayerNumber();

            InputValidator.validatePatternWithUnique(playerNumber);
            numberBaseballService.setPlayerNumbers(playerNumber);

            numberBaseballService.comparePlayerWithComputer();

            outputView.printHintMessage(numberBaseballService.getHintMessage());

            isCompleted = numberBaseballService.isCompleted();
        }

        outputView.printSuccessMessage();
    }
}
