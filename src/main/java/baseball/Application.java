package baseball;

import baseball.controller.GameController;
import baseball.view.GameView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        do {
            GameController gameController = new GameController();
            gameController.playGame();
        } while (retryGame());
    }

    public static boolean retryGame() {
        GameView gameView = new GameView();
        String retryNumber = gameView.printRestartMessage();

        if (retryNumber.equals("1")) {
            return true;
        } else if (retryNumber.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
