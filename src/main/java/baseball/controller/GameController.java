package baseball.controller;

import baseball.domain.Game;

public class GameController {

    public void startGame() {
        Game game = new Game();
        game.startGame();
    }

}
