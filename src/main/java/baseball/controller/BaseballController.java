package baseball.controller;

import baseball.service.BaseballService;
import baseball.service.ComputerService;
import baseball.service.ValidationService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {
    private final BaseballService baseballService = new BaseballService();
    private final ValidationService validationService = new ValidationService();
    private final ComputerService computerService = new ComputerService();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        outputView.startGame();
        gameStart();
    }

    public void gameStart() {
        String randomNumber = computerService.createRandomNumber();
        Boolean isDifferent = true;

        while (isDifferent) {
            String input = inputView.getInput();
            validationService.isValidNumber(input);
            isDifferent = baseballService.startGame(randomNumber, input);
        }
        outputView.endGame();
        promptForRestart();
    }

    public void promptForRestart() {
        String choice = inputView.getUserReplayChoice();
        if (choice.equals("1")) {
            gameStart();
        }
    }
}
