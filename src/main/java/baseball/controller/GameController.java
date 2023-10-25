package baseball.controller;

import static baseball.constants.DigitConstants.RESTART_ANSWER;

import baseball.constants.MessageConstants;
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
        outputView.printlnMessage(MessageConstants.GAME_START_MESSAGE);
    }

    public void playGame() {
        Boolean isRunning = true;
        while (isRunning) {
            computerController.saveRandomNumbers();
            proceedGame();
            outputView.printlnMessage(MessageConstants.RESTART_OR_EXIT_MESSAGE);
            isRunning = requestRestartOrExit();
        }
    }

    private void proceedGame() {
        Boolean isCorrectAnswer = false;
        while (!isCorrectAnswer) {
            Hint hint = guessNumberAndGetHint();
            outputView.printContents(hint.generateHintMessage());
            isCorrectAnswer = computerController.checkCorrectAnswer(hint);
        }
        outputView.printlnMessage(MessageConstants.CORRECT_ANSWER_MESSAGE);
    }

    private Hint guessNumberAndGetHint() {
        outputView.printMessage(MessageConstants.NUMBER_REQUEST_MESSAGE);
        return computerController.provideHint(getPlayerNumber());
    }

    private Numbers getPlayerNumber() {
        String numberString = inputView.readInput();
        NumberValidator.validateNumber(numberString);
        return Numbers.from(Parser.parseNumbers(numberString));
    }

    private Boolean requestRestartOrExit() {
        String response = inputView.readInput();
        RestartOrExitValidator.validateRestartOrExit(response);
        return Parser.parseRestartOrExit(response).equals(RESTART_ANSWER);
    }
}
