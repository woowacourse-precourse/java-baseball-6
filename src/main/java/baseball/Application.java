package baseball;

import baseball.game.BaseballGame;
import baseball.game.Game;

public class Application {

    public static void main(String[] args) {
        Game baseballGame = new BaseballGame();
        baseballGame.run();
    }
}
