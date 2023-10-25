package baseball;

import baseball.controller.Game;
import baseball.controller.Exit;

public class Application {
    public static void main(String[] args) {
        do {
            Game game = new Game();
            game.run();
        } while (Exit.restartOrEnd());

    }
}
