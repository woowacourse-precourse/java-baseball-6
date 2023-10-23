package baseball.controller;

import baseball.model.GameNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

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
        }
    }

    private void userGuessing() {
        boolean isAnswer = false;
        while (!isAnswer) {
            String userInputString = inputView.getUserGuessingNumbers();
            saveUserNumbers(userInputString);
            isAnswer = computerController.checkUserInputWithAnswer(gameNumber.getUserInputNumbers(), gameNumber.getComputerGenerateNumbers());
            outputView.printHint(computerController.createHintMessage());
        }

    }

    private void saveComputerGenerateNumbers() {
        computerController.startGame(gameNumber);
    }

    private void saveUserNumbers(String userInputString) {
        gameNumber.setUserInputString(userInputValidator.userInputStringValidate(userInputString));
        gameNumber.setUserInputNumbers(userInputValidator.userInputNumbersValidate(gameNumber.getUserInputString()));
    }
}
