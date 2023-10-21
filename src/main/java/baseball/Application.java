package baseball;

import baseball.game.BaseballGame;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame(3);
        do {
            baseballGame.start();
        } while (baseballGame.restart());
        baseballGame.end();
    }
}
