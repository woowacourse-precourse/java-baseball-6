package baseball.controller;

import baseball.domain.Game;

public class GameController {

    public void start() {
        Game game = new Game();
        game.startGame();
        game.proceedGame();
        game.restartOrExitGame();
    }

}
