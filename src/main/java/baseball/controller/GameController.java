package baseball.controller;

import baseball.model.Balls;
import baseball.model.RandomGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    RandomGenerator randomGenerator = new RandomGenerator();
    Balls computer;
    Balls player;


    public void run() {
        startGame();
        do {
            inputPlayerNumber();
        } while (isGameFinish());
    }

    private boolean isGameFinish() {
    }

    private void inputPlayerNumber() {
        player = new Balls(inputView.inputPlayerNumber());
    }

    private void startGame() {
        outputView.printStartMessage();
        computer = new Balls(randomGenerator.createNumbers());
    }
}
