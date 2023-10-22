package baseball.controller;

import baseball.Judge;
import baseball.RandomNumberGenerator;
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

    }
}
