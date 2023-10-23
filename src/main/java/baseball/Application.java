package baseball;

import baseball.controller.BaseballController;
import baseball.service.BaseballService;

public class Application {
    public static void main(String[] args) {
        createBaseballController().run();
    }

    private static BaseballController createBaseballController() {
        BaseballService baseballService = new BaseballService();
        return new BaseballController(baseballService);
    }
}
