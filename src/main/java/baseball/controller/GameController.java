package baseball.controller;

import baseball.utils.Parser;
import baseball.validators.NumberValidator;
import baseball.validators.RestartOrExitValidator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private ComputerController computerController = new ComputerController();

    public GameController() {
        outputView.gameStart();
    }

    public void playGame() {
        Boolean isRunning = true;
        while (isRunning) {
            computerController.saveRandomNumbers();
            proceedGame();
            isRunning = requestRestartOrExit();
        }
    }

    private void proceedGame() {
        Boolean isCorrectAnswer = false;
        while (!isCorrectAnswer) {
            outputView.requestInputNumber();
            List<Integer> playerNumbers = getPlayerNumbers();
            computerController.provideHint(playerNumbers);
            outputView.askRestartOrExit();
            isCorrectAnswer = computerController.checkCorrectAnswer();
        }
        outputView.notifyCorrectAnswer();
    }

    private List<Integer> getPlayerNumbers() {
        String inputNumbers = inputView.readInputNumbers();
        NumberValidator.validateNumber(inputNumbers);
        return Parser.parseStringToList(inputNumbers);
    }

    private Boolean requestRestartOrExit() {
        String response = inputView.readRestartOrOver();
        RestartOrExitValidator.validateRestartOrExit(response);
        return response.equals("1");
    }
}
