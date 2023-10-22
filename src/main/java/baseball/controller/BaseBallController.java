package baseball.controller;

import baseball.Judge;
import baseball.RandomNumberGenerator;
import baseball.ScoreBoard;
import baseball.User;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallController {
    private Judge judge;

    public void playGame() {
        OutputView.startGameMessage();
        do {
            judge = new Judge(RandomNumberGenerator.createRandomNumber());
            run();
        } while (true);
    }

    private void run() {
        do {
            User user = new User(InputView.inputUserNumber());
            ScoreBoard scoreBoard = judge.evaluateUserNumberList(user.getUserNumberList());
        } while (true);
    }
}
