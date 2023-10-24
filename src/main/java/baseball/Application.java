package baseball;

import baseball.domain.BaseballGame;
import game.Game;
import game.GameExecutor;

public class Application {

    public static void main(String[] args) {
        Game game = new BaseballGame(new MissionUtilsGameRandom(), new ConsoleInput(), new ConsoleLogger());
        GameExecutor gameExecutor = new GameExecutor(game);
        gameExecutor.run();
    }
}
