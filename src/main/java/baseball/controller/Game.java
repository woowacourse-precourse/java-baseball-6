package baseball.controller;

import baseball.game.GameManager;

public class Game {
    private GameManager gameManager;

    public Game() {
        this.gameManager = new GameManager();
    }

    public void gameStart() {
        boolean playGame = true;
        gameManager.startGame();
        while(playGame) {
            gameManager.inputUserNumber();
            gameManager.showBallCount();

            boolean gameOver = gameManager.checkGameOver();

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
