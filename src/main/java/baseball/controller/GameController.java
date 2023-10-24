package baseball.controller;

import baseball.service.game.BaseballGame;
import baseball.service.game.GameInterface;

public class GameController {
    private final GameInterface gameInterface;

    public GameController() {
        this.gameInterface = new BaseballGame();
        gameInterface.play();
    }
}
