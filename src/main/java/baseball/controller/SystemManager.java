package baseball.controller;

public class SystemManager {
    public static void newGame() {
        GameManager gameManager = new GameManager();
        gameManager.playRound();
    }
}
