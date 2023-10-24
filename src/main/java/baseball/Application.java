package baseball;

import baseball.game.GameManager;
import baseball.player.Player;

public class Application {
    static GameManager gameManager = new GameManager();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        gameManager.gameStart();
    }
}
