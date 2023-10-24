package baseball;

import baseball.controller.RunController;

public class Application {

    public static void main(String[] args) {
        RunController runController = new RunController();
        runController.run();
    }
}
