package baseball;

import baseball.config.DependencyContainer;
import baseball.controller.MainController;

public class Application {
    public static void main(String[] args) {
        DependencyContainer dependencyContainer = new DependencyContainer();
        MainController mainController = dependencyContainer.getMainController();
        mainController.startGame();
    }
}
