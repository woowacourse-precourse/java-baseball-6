package baseball;

import baseball.controller.MainController;

public class Application {
    public static void main(String[] args) {
        MainController mainController = MainController.getMainController();
        mainController.run();

    }
}
