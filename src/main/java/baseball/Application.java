package baseball;

import baseball.game.BaseballGame;

public class Application {

    private static final BaseballGame baseballGame = new BaseballGame();

    public static void main(String[] args) {
        baseballGame.start();
    }
}
