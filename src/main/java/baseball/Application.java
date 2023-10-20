package baseball;

import baseball.baseball.BaseballGameConsoleView;
import baseball.baseball.BaseballGameService;
import baseball.baseball.RandomBaseballNumberGenerator;
import baseball.game.system.GameSystem;
import baseball.game.system.ReplayableGameSystem;
import baseball.game.system.ReplayableGameSystemConsoleView;
import baseball.game.turn.TurnBasedGame;

public class Application {
    public static void main(String[] args) {
        GameSystem gameSystem = new ReplayableGameSystem(new ReplayableGameSystemConsoleView(),
                new TurnBasedGame(new BaseballGameConsoleView(),
                        new BaseballGameService(new RandomBaseballNumberGenerator())));
        gameSystem.run();
    }
}
