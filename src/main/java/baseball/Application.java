package baseball;

import baseball.game.BaseballGame;
import baseball.game.Game;

public class Application {
    public static void main(String[] args) {
        Game game = new BaseballGame();
        game.start();
    }
}
