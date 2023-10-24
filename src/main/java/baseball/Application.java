package baseball;

import baseball.config.DependencyContainer;
import baseball.controller.MainController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        DependencyContainer dependencyContainer = new DependencyContainer();
        MainController mainController = dependencyContainer.getMainController();
        mainController.startBaseballGame();
    }
}
