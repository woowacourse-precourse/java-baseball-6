package baseball;

import baseball.controller.GameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        do {
            GameController gameController = new GameController();
            gameController.playGame();
        } while (retryGame());
    }

    public static boolean retryGame() {
        return true;
    }
}
