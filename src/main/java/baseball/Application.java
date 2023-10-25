package baseball;

import baseball.console.InputConsole;
import baseball.console.MainController;
import baseball.console.OutputConsole;
import baseball.controller.GameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController(new MainController(new InputConsole(), new OutputConsole()));
        gameController.start();

    }
}
