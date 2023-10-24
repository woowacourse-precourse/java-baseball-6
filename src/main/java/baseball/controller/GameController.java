package baseball.controller;

import baseball.utils.Parser;
import baseball.validators.NumberValidator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private ComputerController computerController = new ComputerController();
    private PlayerController playerController = new PlayerController();

    public GameController() {
        outputView.gameStart();
    }

    public void playGame() {
        Boolean isRunning = true;
        while (isRunning) {
            computerController.saveRandomNumbers();
            proceedGame();
            isRunning = askIfContinue();
        }
    }

    private void proceedGame() {
        Boolean isCorrectAnswer = false;
        while (!isCorrectAnswer) {
            outputView.requestInputNumber();
            List<Integer> playerNumbers = getPlayerNumbers();
            computerController.provideHint(playerNumbers);
            isCorrectAnswer = computerController.checkCorrectAnswer();
        }
        outputView.notifyCorrectAnswer();
    }

    private List<Integer> getPlayerNumbers() {
        String inputNumbers = inputView.readInputNumbers();
        NumberValidator.validateNumber(inputNumbers);
        return Parser.parseStringToList(inputNumbers);
    }

    private Boolean askIfContinue() {
        outputView.askRestartOrExit();
        Integer answer = playerController.restartOrOver();
        if (answer == 1) {
            return true;
        }
        return false;
    }
}
