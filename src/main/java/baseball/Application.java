package baseball;

import baseball.computer.GameController;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.startGame();
    }
}
