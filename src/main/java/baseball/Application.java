package baseball;

import baseball.controller.BaseballGame;
import baseball.controller.Game;

public class Application {

    public static void main(String[] args) {
        Game baseballGame = new BaseballGame();
        baseballGame.run();
    }
}
