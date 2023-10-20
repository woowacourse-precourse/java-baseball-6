package baseball;

import baseball.controller.Controller;

public class Application {
    private static final Controller controller = new Controller();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        controller.run();
    }
}
