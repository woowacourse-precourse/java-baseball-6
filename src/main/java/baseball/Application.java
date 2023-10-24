package baseball;

import baseball.controller.RunController;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        RunController runController = new RunController();
        runController.run();
    }
}
