package baseball;

import baseball.controller.GameController;
import baseball.view.StartView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(
                new StartView());
        gameController.play();
    }
}