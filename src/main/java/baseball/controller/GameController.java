package baseball.controller;

import baseball.view.ConsoleView;

public class GameController {
    public void start() {
        boolean finish = false;
        ConsoleView.printGameStart();
        while (finish) {
            finish = executeGame();
        }
    }

    public boolean executeGame() {

        return true;
    }
}
