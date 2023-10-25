package baseball;

import baseball.service.Game;
import baseball.ui.ConsoleInput;
import baseball.ui.ConsoleOutput;

public class Application {
    public static void main(String[] args) {

        Game game = new Game(3, new ConsoleInput(), new ConsoleOutput());
        game.run();
    }
}
