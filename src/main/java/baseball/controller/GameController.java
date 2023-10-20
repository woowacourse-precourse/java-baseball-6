package baseball.controller;

import baseball.service.BaseballGame;
import baseball.service.GameInterface;

public class GameController {
    private final GameInterface gameInterface;

    public GameController() {
        this.gameInterface = new BaseballGame();
        gameInterface.play();
    }
}
