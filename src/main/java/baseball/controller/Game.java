package baseball.controller;

import baseball.game.GameManager;

public class Game {
    private GameManager gameManager;

    public Game() {
        this.gameManager = new GameManager();
    }

    public void gameStart() {
        gameManager.startGame();

        boolean playGame = true;
        boolean gameOver;

        while(playGame) {
            gameManager.inputUserNumber();
            gameOver = gameManager.checkResult();

            if (gameOver) {
                boolean restartOrNot = gameManager.askRestartGame();
                playGame = restartGame(restartOrNot);
            }
        }
    }

    private boolean restartGame(boolean wantRestart) {
        if (!wantRestart) {
            return false;
        }

        gameManager = new GameManager();
        return true;
    }
}
