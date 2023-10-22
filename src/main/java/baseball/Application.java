package baseball;

import baseball.controller.UserInputValidator;
import baseball.model.GameNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        outputView.printGameStart();

        InputView inputView = new InputView();
        String userInputString = inputView.getUserGuessingNumbers();

        GameNumber gameNumber = new GameNumber();
        UserInputValidator userInputValidator = new UserInputValidator();
        String validatedUserInputString = userInputValidator.userInputStringValidate(userInputString);
        gameNumber.setUserInputString(validatedUserInputString);
        System.out.println("userInputString = " + gameNumber.getUserInputString());

        outputView.printGameFinish();
    }
}
