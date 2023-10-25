package baseball;

import baseball.module.api.GameController;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.run();
    }
}
