package baseball;

import baseball.game.BaseballGame;
import baseball.game.GameManager;

public class Application {
    public static void main(String[] args) {
        var game = new BaseballGame();
        GameManager.start(game);
    }
}
