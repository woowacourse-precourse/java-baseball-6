package baseball;

import baseball.controller.SystemController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        SystemController systemController = new SystemController();

        systemController.run();
    }
}
