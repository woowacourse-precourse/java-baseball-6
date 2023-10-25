package baseball.controller;

import baseball.model.Balls;
import baseball.model.Hint;
import baseball.model.RandomGenerator;
import baseball.util.NumberConst;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    Hint hint;

    RandomGenerator randomGenerator = new RandomGenerator();
    Balls computer;
    Balls player;


    public void run() {
        startGame();
        do {
            inputPlayerNumber();
        } while (!isGameFinish());
        RestartOrStopGame();
    }

    private void RestartOrStopGame() {
        outputView.printCorrectMessage();
        if (inputView.inputRestartOrStop() == NumberConst.RESTART_OPTION) {
            run();
        }
    }

    private boolean isGameFinish() {
        hint = new Hint();
        hint.getStrikeAndBallCount(computer, player);
        outputView.printHint(hint);

        return hint.isGameFinish();
    }

    private void inputPlayerNumber() {
        player = new Balls(inputView.inputPlayerNumber());
    }

    private void startGame() {
        outputView.printStartMessage();
        computer = new Balls(randomGenerator.createNumbers());
    }
}
