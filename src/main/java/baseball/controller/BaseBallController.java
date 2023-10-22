package baseball.controller;

import baseball.Judge;
import baseball.RandomNumberGenerator;
import baseball.ScoreBoard;
import baseball.User;
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
        } while (true);
    }

    private void run() {
        do {
            user = new User(InputView.inputUserNumber());
            scoreBoard = judge.evaluateUserNumberList(user.getUserNumberList());
            OutputView.showScoreBoard(scoreBoard);
        } while (!scoreBoard.isThreeStrike());
        OutputView.gameOverMessage();
        InputView.inputRestartOption();
    }
}
