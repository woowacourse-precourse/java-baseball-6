package baseball.controller;

import baseball.model.ComputerBalls;
import baseball.model.Score;
import baseball.model.UserBalls;
import baseball.view.InputView;
import baseball.view.OutputView;


public class BaseballGame {
    public static void run() {
        Score score = new Score();
        ComputerBalls computerBalls = new ComputerBalls();
        OutputView.startGame();
        while (!score.isThreeStrikes()) {
            score = playGame(computerBalls);
            OutputView.printResult(score.getBall(), score.getStrike());
        }
        OutputView.printGameEnd();
    }

    private static Score playGame(ComputerBalls computerBalls) {
        String input = InputView.inputNumbers();
        UserBalls userBalls = new UserBalls(input);
        return GameRules.getScore(computerBalls.getComputerBalls(), userBalls.getUserBalls());
    }
}