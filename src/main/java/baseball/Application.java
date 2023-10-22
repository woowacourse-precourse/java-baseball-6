package baseball;

import baseball.controller.ComputerController;

public class Application {
    public static void main(String[] args) {
        ComputerController computerController = new ComputerController();
        computerController.startGame();
    }
}
