package baseball;

import baseball.controller.BaseballGameController;
import baseball.handler.InputHandler;
import baseball.handler.OutputHandler;
import baseball.service.BaseballGameService;
import baseball.view.ConsoleInput;
import baseball.view.ConsoleOutput;

public class Application {

    public static void main(String[] args) {

        final InputHandler inputHandler = new ConsoleInput();
        final OutputHandler outputHandler = new ConsoleOutput();
        final BaseballGameService baseballGameService = new BaseballGameService();

        new BaseballGameController(inputHandler, outputHandler, baseballGameService).run();
    }
}
