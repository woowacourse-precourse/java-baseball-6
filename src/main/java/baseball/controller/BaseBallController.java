package baseball.controller;

import baseball.RandomNumberGenerator;
import baseball.RestartOption;
import baseball.model.Judge;
import baseball.model.ScoreBoard;
import baseball.model.User;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallController {
    public static void playGame() {
        OutputView.startGameMessage();
        do {
            run();
        } while (RestartOption.isRestart(InputView.inputRestartOption()));
    }

    private static void run() {
        ScoreBoard scoreBoard;
        User user;
        Judge judge = new Judge(RandomNumberGenerator.createRandomNumber());
        do {
            user = new User(InputView.inputUserNumber());
            scoreBoard = judge.recordScoreBoard(user.getUserNumberList());
            OutputView.showScoreBoard(scoreBoard);
        } while (!scoreBoard.isThreeStrike());
        OutputView.gameOverMessage();
    }
}
