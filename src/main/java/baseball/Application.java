package baseball;

import baseball.controller.BaseBallApp;

public class Application {
    private static final BaseBallApp baseBallApp = new BaseBallApp();

    public static void main(String[] args) {
        baseBallApp.run();
    }
}
