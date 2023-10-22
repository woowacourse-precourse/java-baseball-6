package baseball.controller;

import baseball.model.Balls;
import baseball.model.RandomGenerator;
import baseball.view.OutputView;

public class GameController {
    OutputView outputView = new OutputView();

    RandomGenerator randomGenerator = new RandomGenerator();
    Balls computer;
    Balls player;


    public void run() {
        startGame();
    }

    private void startGame() {
        outputView.printStartMessage();
        computer = new Balls(randomGenerator.createNumbers());
    }
}
