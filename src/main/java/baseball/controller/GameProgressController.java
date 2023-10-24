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
            saveComputerGenerateNumbers();
            userGuessing();
            progressState = userRestartOrExit(inputView.getUserRestartOrExitNumber());
        }
    }

    private boolean userRestartOrExit(String userInputString) {
        int userInputRestartOrExitNumber = userInputValidator.userInputRestartOrExitValidate(userInputString);
        if (userInputRestartOrExitNumber == 1) {
            return true;
        }
        if (userInputRestartOrExitNumber == 2) {
            return false;
        }
        throw new IllegalArgumentException();
    }

    private void userGuessing() {
        boolean isAnswer = false;
        while (!isAnswer) {
            String userInputString = inputView.getUserGuessingNumbers();
            saveUserNumbers(userInputString);
            isAnswer = computerController.checkUserInputWithAnswer(gameNumber);
            outputView.printHint(computerController.createHintMessage());
        }
        if (isAnswer) {
            outputView.printGameFinish();
        }
    }

    private void saveUserNumbers(String userInputString) {
        String validUserInputString = userInputValidator.userInputStringValidate(userInputString);
        List<Integer> validUserInputNumbers = userInputValidator.userInputNumbersValidate(validUserInputString);
        gameNumber.saveUserInputNumbers(validUserInputString, validUserInputNumbers);
    }

    private void saveComputerGenerateNumbers() {
        computerController.startGame(gameNumber);
    }

}
