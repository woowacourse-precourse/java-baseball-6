package controller;

import entity.NumberBaseball;
import view.InputView;
import view.OutputView;

public class BaseballController {

    public void startBaseball() {
        OutputView.printGameStartView();
        getUserNumber();
    }

    public void getUserNumber() {
        NumberBaseball userNumberBaseball = new NumberBaseball();
        while (true) {
            String userInput = InputView.getUserInput();
            userNumberBaseball.isValid(userInput);
            if (userNumberBaseball.isPerfect(userInput)) {
                break;
            }
            printResult(userNumberBaseball, userInput);

        }
    }

    private void printResult(NumberBaseball baseball, String userInput) {
        if (baseball.isNothing(userInput)) {
            OutputView.printNothing();
        }

        int ballCount = baseball.countBall(userInput);
        int strikeCount = baseball.countStrike(userInput);

        OutputView.printBallCount(ballCount);
        OutputView.printStrikeCount(strikeCount);
    }
}
