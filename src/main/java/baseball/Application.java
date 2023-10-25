package baseball;

import baseball.controller.GameController;
import baseball.view.Console;

public class Application {
    public static void main(String[] args) {
        Console.printStartGame();

        GameController controller = new GameController();
        controller.start();
    }
}
