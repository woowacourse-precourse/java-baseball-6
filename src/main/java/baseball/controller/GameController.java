package baseball.controller;

import baseball.constants.GameMessages;
import baseball.model.Hint;
import baseball.model.Numbers;
import baseball.utils.Parser;
import baseball.validators.NumberValidator;
import baseball.validators.RestartOrExitValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

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
            Hint hint = computerController.provideHint(getPlayerNumber());
            outputView.printContents(hint.generateHintMessage());
            isCorrectAnswer = computerController.checkCorrectAnswer(hint);
        }
        outputView.printlnMessage(GameMessages.CORRECT_ANSWER_MESSAGE);
    }

    private Numbers getPlayerNumber() {
        String numberString = inputView.readInputNumbers();
        NumberValidator.validateNumber(numberString);
        return Numbers.from(Parser.parseNumbers(numberString));
    }

    private boolean requestRestartOrExit() {
        String response = inputView.readRestartOrOver();
        RestartOrExitValidator.validateRestartOrExit(response);
        return Parser.parseRestartOrExit(response).equals(1);
    }
}
