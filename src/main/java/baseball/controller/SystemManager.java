package baseball.controller;

public class SystemManager {
    static public void newGame() {
        GameManager gameManager = new GameManager();
        gameManager.playRound();
    }
}
