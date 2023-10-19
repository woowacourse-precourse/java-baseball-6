package baseball.api;

import baseball.application.BaseballGameService;
import baseball.entity.NumberBaseball;
import baseball.utils.InputUtil;
import baseball.view.OutputView;

public class BaseballController {

    BaseballGameService baseballGameService = new BaseballGameService();

    public void startBaseball() {
        OutputView.printGameStartView();
        baseballGameService.startGame();
    }

    public void getUserNumber() {
        NumberBaseball userNumberBaseball = new NumberBaseball();
        while (true) {
            String userInput = InputUtil.requireGuessNumber();
            userNumberBaseball.isValid(userInput);
            printResult(userNumberBaseball, userInput);
            if (userNumberBaseball.isPerfect(userInput)) {
                break;
            }
        }
        OutputView.printEndGame();
        String restartNumber = InputUtil.requireGuessNumber();
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
            return;
        }

        int ballCount = baseball.countBall(userInput);
        int strikeCount = baseball.countStrike(userInput);

        OutputView.printBallCount(ballCount);
        OutputView.printStrikeCount(strikeCount);
    }
}
