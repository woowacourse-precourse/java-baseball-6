package baseball;

import baseball.baseball.BaseballGameConsoleView;
import baseball.baseball.BaseballGameService;
import baseball.baseball.RandomBaseballNumberGenerator;
import baseball.game.Game;
import baseball.game.turn.TurnBasedGame;

public class GameFactory {
    private GameFactory() {
    }

    public static Game createBaseballGame() {
        return new TurnBasedGame(new BaseballGameConsoleView(),
                new BaseballGameService(new RandomBaseballNumberGenerator()));
    }
}
