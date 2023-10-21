package baseball;

import baseball.controller.BaseballController;

public class Application {

    private Application() {
    }

    public static void main(String[] args) {
        new BaseballController().run();
    }
}
