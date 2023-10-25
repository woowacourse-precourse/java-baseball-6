package baseball;

import baseball.domain.game.GamePlay;

public class Application {
    public static void main(String[] args) {
        GamePlay gamePlay = new GamePlay();
        gamePlay.runFullGame();
    }
}
