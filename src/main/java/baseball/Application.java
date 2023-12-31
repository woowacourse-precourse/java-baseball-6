package baseball;

import baseball.controller.BaseballController;

public class Application {

    public static void main(String[] args) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        BaseballController controller = new BaseballController(applicationConfig.baseballService());
        controller.run();
    }
}
