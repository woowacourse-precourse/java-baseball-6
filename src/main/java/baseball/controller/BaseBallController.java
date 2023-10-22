package baseball.controller;

import baseball.model.Judge;
import baseball.RandomNumberGenerator;
import baseball.RestartOption;
import baseball.model.ScoreBoard;
import baseball.model.User;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallController {
    private Judge judge;
    private User user;
    private ScoreBoard scoreBoard;
    private RestartOption restartOption;

    public void playGame() {
        OutputView.startGameMessage();
        do {
            judge = new Judge(RandomNumberGenerator.createRandomNumber());
            run();
        } while (restartOption.isRestart());
    }

    private void run() {
        do {
            user = new User(InputView.inputUserNumber());
            scoreBoard = judge.evaluateUserNumberList(user.getUserNumberList());
            OutputView.showScoreBoard(scoreBoard);
        } while (!scoreBoard.isThreeStrike());
        OutputView.gameOverMessage();
        restartOption = new RestartOption(InputView.inputRestartOption());
    }
}
