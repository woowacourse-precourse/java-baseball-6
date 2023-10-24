package baseball.controller;

import baseball.model.Computer;
import baseball.model.Inning;

import java.util.ArrayList;

import static baseball.Config.SUCCESS;

public class GameController {
    private final IOController ioController;

    public GameController() {
        this.ioController = new IOController();
    }

    public void gameStart() {
        ioController.gameStartNotify();
        inGame();
    }

    private void inGame() {
        Computer computer = new Computer();
        ArrayList<Integer> answer = computer.getGeneratedNumbers();
        while (true) {
            ArrayList<Integer> input = ioController.inningNumberInput();
            Inning inning = new Inning(answer, input);
            ioController.showResult(inning.calculateResult());
            if (inning.calculateResult().equals(SUCCESS)) {
                restart();
                break;
            }
        }
    }

    private void restart() {
        ioController.gameEndNotify();
        int restart = ioController.restartNumberInput();
        if (restart == 1) {
            inGame();
        }
    }
}
