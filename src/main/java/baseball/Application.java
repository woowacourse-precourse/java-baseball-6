package baseball;

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
        gameNumber.setUserInputString(userInputString);
        System.out.println("userInputString = " + gameNumber.getUserInputString());

        outputView.printGameFinish();
    }
}
