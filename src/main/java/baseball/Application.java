package baseball;

import baseball.controller.BaseballGameController;
import baseball.handler.InputHandler;
import baseball.view.ConsoleInput;

public class Application {

    public static void main(String[] args) {

        final InputHandler inputHandler = new ConsoleInput();

        new BaseballGameController(inputHandler).run();
    }
}
