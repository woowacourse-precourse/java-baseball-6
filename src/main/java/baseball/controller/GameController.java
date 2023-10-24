package baseball.controller;

import baseball.model.Computer;
import baseball.model.Inning;

import java.util.ArrayList;

public class GameController {
    private final IOController ioController;

    public GameController() {
        this.ioController = new IOController();
    }

    public void gameStart() {
        ioController.gameStartNotify();
        ArrayList<Integer> answer = Computer.getNumbers(3);
        inGame(answer);
    }

    private void inGame(ArrayList<Integer> answer) {
        while (true) {
            ArrayList<Integer> input = ioController.inningNumberInput();
            Inning inning = new Inning(answer, input);
            ioController.showResult(inning.calculateResult());
            if (inning.calculateResult().equals("3스트라이크")) {
                restart();
                break;
            }
        }
    }

    private void restart() {
        ioController.gameEndNotify();
        int restart = ioController.restartNumberInput();
        if (restart == 1) {
            ArrayList<Integer> answer = Computer.getNumbers(3);
            inGame(answer);
        }
    }
}
