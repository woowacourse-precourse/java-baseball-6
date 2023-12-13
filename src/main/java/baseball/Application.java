package baseball;

import baseball.configuration.AppConfig;
import baseball.controller.BaseballController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        BaseballController controller = appConfig.baseballController();
        controller.run();
    }
}
