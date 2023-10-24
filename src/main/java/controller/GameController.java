package controller;

import service.GamePlayService;

public class GameController {

    private GamePlayService gamePlayService = new GamePlayService();

    public void startGame() {
        gamePlayService.playGame();
    }

}
