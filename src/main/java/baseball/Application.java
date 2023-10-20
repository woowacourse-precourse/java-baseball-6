package baseball;

import baseball.game.BaseballGame;
import baseball.game.GameManager;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        var game = new BaseballGame();
        GameManager.start(game);
    }
}
