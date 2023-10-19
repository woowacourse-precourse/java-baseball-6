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
            printResult(userNumberBaseball, userInput);
            if (userNumberBaseball.isPerfect(userInput)) {
                break;
            }
        }
        OutputView.printEndGame();
        String restartNumber = InputView.getUserInput();
        checkRestartNumberValidation(restartNumber);
        if (restartNumber.equals("1")) {
            getUserNumber();
        }
    }

    private void checkRestartNumberValidation(String restartNumber) {
        if (restartNumber.equals("1") || restartNumber.equals("2")) {
            return;
        }
        throw new IllegalArgumentException();
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
