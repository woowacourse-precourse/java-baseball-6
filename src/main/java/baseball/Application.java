package baseball;

import baseball.controller.BaseballGameController;
import baseball.handler.InputHandler;
import baseball.handler.OutputHandler;
import baseball.view.ConsoleInput;
import baseball.view.ConsoleOutput;

public class Application {

    public static void main(String[] args) {

        final InputHandler inputHandler = new ConsoleInput();
        final OutputHandler outputHandler = new ConsoleOutput();

        new BaseballGameController(inputHandler, outputHandler).run();
    }
}
