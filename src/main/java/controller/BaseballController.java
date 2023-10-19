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
        String userInput = InputView.getUserInput();
        NumberBaseball userNumberBaseball = new NumberBaseball(userInput);
        userNumberBaseball.isValid();
        printResult(userNumberBaseball);
    }

    private void printResult(NumberBaseball baseball) {
        if (baseball.isNothing()) {
            OutputView.printNothing();
        }

        int ballCount = baseball.countBall();
        int strikeCount = baseball.countStrike();

        OutputView.printBallCount(ballCount);
        OutputView.printStrikeCount(strikeCount);
    }
}
