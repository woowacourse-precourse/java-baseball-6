package baseball;

import baseball.config.DiContainer;
import baseball.controller.Controller;

public class Application {
    public static void main(String[] args) {
        DiContainer diFactory = new DiContainer();
        Controller GameController = diFactory.userController();
        GameController.gameStart();
    }
}
