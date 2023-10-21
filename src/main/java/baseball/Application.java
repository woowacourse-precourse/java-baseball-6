package baseball;

import baseball.controller.GameController;
import baseball.view.GameView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.play();
    }
}
