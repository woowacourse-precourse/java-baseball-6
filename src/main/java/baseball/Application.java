package baseball;

import baseball.config.DiContainer;
import baseball.controller.ComputerController;

public class Application {
    public static void main(String[] args) {
        DiContainer diFactory = new DiContainer();
        ComputerController computerController = diFactory.computerController();
        computerController.gameStart();
    }
}
