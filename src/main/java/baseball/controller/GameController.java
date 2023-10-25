package baseball.controller;

import baseball.constants.GameMessages;
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
        outputView.printlnMessage(GameMessages.GAME_START_MESSAGE);
    }

    public void playGame() {
        Boolean isRunning = true;
        while (isRunning) {
            computerController.saveRandomNumbers();
            proceedGame();
            outputView.printlnMessage(GameMessages.RESTART_OR_EXIT_MESSAGE);
            isRunning = requestRestartOrExit();
        }
    }

    private void proceedGame() {
        Boolean isCorrectAnswer = false;
        while (!isCorrectAnswer) {
            outputView.printMessage(GameMessages.NUMBER_REQUEST_MESSAGE);
            List<Integer> playerNumbers = getPlayerNumbers();
            computerController.provideHint(playerNumbers);
            isCorrectAnswer = computerController.checkCorrectAnswer();
        }
        outputView.printlnMessage(GameMessages.CORRECT_ANSWER_MESSAGE);
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
