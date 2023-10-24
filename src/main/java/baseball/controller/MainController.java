package baseball.controller;

import baseball.service.GameService;

public class MainController {

    private GameService gameService = new GameService();

    public void gameStart() {
        boolean gameStopFlag = false;
        while (!gameStopFlag) {
            gameStopFlag = gameService.playGame();
        }
    }
}
