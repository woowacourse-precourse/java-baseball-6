package baseball.controller;

import baseball.model.GameNumber;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameProgressController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    GameNumber gameNumber = new GameNumber();
    UserInputValidator userInputValidator = new UserInputValidator();
    ComputerController computerController = new ComputerController();

    public void progressGame() {
        boolean progressState = true;
        while (progressState) {
            outputView.printGameStart();
            computerController.createAndSaveAnswer(gameNumber);
            progressUserGuessing();
            progressState = getRestartOrExit(inputView.askRestartOrExitNumber());
        }
    }

    private boolean getRestartOrExit(String userInputString) {
        int userInputRestartOrExitNumber = userInputValidator.validateRestartOrExitInput(userInputString);
        if (userInputRestartOrExitNumber == 1) {
            return true;
        }
        if (userInputRestartOrExitNumber == 2) {
            return false;
        }
        throw new IllegalArgumentException();
    }

    private void progressUserGuessing() {
        boolean isAnswer = false;
        while (!isAnswer) {
            String userInputString = inputView.askGuessingNumbers();
            saveUserNumbers(userInputString);
            isAnswer = computerController.checkUserInputWithAnswer(gameNumber);
            outputView.printHint(computerController.createHintMessage());
        }
        if (isAnswer) {
            outputView.printGameFinish();
        }
    }

    private void saveUserNumbers(String userInputString) {
        String validUserInputString = userInputValidator.validateInputString(userInputString);
        List<Integer> validUserInputNumbers = userInputValidator.validateInputNumbers(validUserInputString);
        gameNumber.saveUserInputNumbers(validUserInputString, validUserInputNumbers);
    }
}
