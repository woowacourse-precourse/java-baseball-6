package baseball.controller;

import baseball.model.BaseballService;
import baseball.model.GameNumber;
import baseball.model.Result;
import baseball.view.BaseballView;
import java.util.ArrayList;
import java.util.List;

public class BaseballController {
    static List<Integer> answer = new ArrayList<>();

    public void startGame() {
        BaseballView.printGameStartView();
        do {
            answer = GameNumber.generateNumber();
            getPlayerInput();
            BaseballView.printWinGame();
        } while (willRestartGame());
    }

    public static void getPlayerInput() {
        List<Integer> input = BaseballView.getPlayerInput();
        BaseballService.getResult(input, answer);
        printResult();
        Result.reset();
        if (!answer.equals(input)) {
            getPlayerInput();
        }
    }

    public static void printResult() {
        if (Result.getBall() + Result.getStrike() == 0) {
            BaseballView.printNothing();
            return;
        }
        if (Result.getBall() > 0) {
            BaseballView.printBall(Result.getBall());
        }
        if (Result.getStrike() > 0) {
            BaseballView.printStrike(Result.getStrike());
        }
    }

    public static boolean willRestartGame() {
        String input = BaseballView.chooseRestartGame();
        return GameNumber.getRestartInput(input);
    }
}
