package baseball;

import baseball.controller.BaseballController;

public class Application {
    public static void main(String[] args) {
        createBaseballController().run();
    }

    private static BaseballController createBaseballController() {
        return new BaseballController();
    }
}
