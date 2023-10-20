package baseball.controller;

import baseball.model.Game;
import baseball.view.OutputView;

public class GameController {
    private Game game;

    public GameController() {
        OutputView.printGameStart();
    }

    public void run() {
        this.game = new Game();
    }
}
