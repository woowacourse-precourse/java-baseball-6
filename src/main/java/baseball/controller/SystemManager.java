package baseball.controller;

import baseball.view.OutputHandler;

public class SystemManager {
    static public void firstGame() {
        GameManager gameManager = new GameManager();
        OutputHandler.theGameStart();
        gameManager.playRound();
    }

    static public void newGame() {
        GameManager gameManager = new GameManager();
        gameManager.playRound();
    }
}
