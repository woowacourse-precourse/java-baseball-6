package baseball;

import baseball.system.MainController;

public class Application {
    public static void main(String[] args) {
        MainController mainController = MainController.instance();
        mainController.play();
    }
}
