package baseball;

import baseball.controller.MainController;

public class Application {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.playGame();
    }
}
