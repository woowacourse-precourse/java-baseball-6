package baseball;

import controller.ComputerController;

public class Application {
    public static void main(String[] args) {
        ComputerController computerController = new ComputerController();
        computerController.startGame();
    }
}
