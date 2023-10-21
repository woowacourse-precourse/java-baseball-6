package model.system;

import model.referee.GameScoreboard;

public class GameController {

    public GameController() {
    }

    public void run() {
        GameStarter gameStarter = new GameStarter();
        GameTerminator gameTerminator = new GameTerminator();
        boolean runningGame = true;
        while (runningGame) {
            GameScoreboard gameScoreboard = gameStarter.start();
            runningGame = gameTerminator.isGameOver(gameScoreboard);
        }
    }

}
