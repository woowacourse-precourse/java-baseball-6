package baseball;

import baseball.game.system.GameSystem;
import baseball.game.system.ReplayableGameSystem;
import baseball.game.system.ReplayableGameSystemConsoleView;

public class Application {
    public static void main(String[] args) {
        GameSystem gameSystem = new ReplayableGameSystem(
                new ReplayableGameSystemConsoleView(),
                GameFactory.createBaseballGame());

        gameSystem.run();
    }
}
