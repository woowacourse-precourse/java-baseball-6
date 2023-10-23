package baseball.controller;

import baseball.model.Balls;
import baseball.util.RandomNumberGenerator;
import baseball.view.OutputView;

public class GameController {

    private OutputView outputView;
    private Balls com;

    public void start() {
        init();
        outputView.printGameStart();
    }

    private void init() {
        outputView = new OutputView();
        com = new Balls(RandomNumberGenerator.createRandomNumbers());
    }
}
