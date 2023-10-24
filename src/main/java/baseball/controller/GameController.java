package baseball.controller;

import baseball.model.Computer;
import baseball.view.GameView;

public class GameController {
    private Computer computer;
    private GameView gameView;

    public GameController() {
        this.computer = new Computer();
        this.gameView = new GameView();
    }
}
