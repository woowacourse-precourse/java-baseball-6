package baseball;

import baseball.controller.GameProgressController;

public class Application {
    public static void main(String[] args) {
        GameProgressController gameProgressController = new GameProgressController();
        gameProgressController.progressGame();
    }
}
