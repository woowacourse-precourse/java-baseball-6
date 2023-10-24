package baseball;

import baseball.Controller.ControllerSystem;
import baseball.View.OutputView;


public class Application {
    private static ControllerSystem controller;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.printStartMessage();
        controller = new ControllerSystem();

        controller.gameStart();
    }
}
