package baseball.module.api;

import baseball.module.application.GameService;

public class GameController {

    GameService gameService = new GameService();

    public void run() throws IllegalArgumentException {
        setGame();
        startGame();
    }

    private void setGame() {
        gameService.setGame();
    }

    private void startGame() {
        gameService.playGame();
    }

}