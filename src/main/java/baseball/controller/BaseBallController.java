package baseball.controller;

import baseball.RandomNumberGenerator;
import baseball.RestartOption;
import baseball.model.Judge;
import baseball.model.ScoreBoard;
import baseball.model.User;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallController {
    private Judge judge;
    private User user;
    private ScoreBoard scoreBoard;

    public void playGame() {
        OutputView.startGameMessage();
        do {
            judge = new Judge(RandomNumberGenerator.createRandomNumber());
            run();
        } while (RestartOption.isRestart(InputView.inputRestartOption()));
    }

    private void run() {
        do {
            user = new User(InputView.inputUserNumber());
            scoreBoard = judge.recordScoreBoard(user.getUserNumberList());
            OutputView.showScoreBoard(scoreBoard);
        } while (!scoreBoard.isThreeStrike());
        OutputView.gameOverMessage();
    }
}
