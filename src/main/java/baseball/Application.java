package baseball;

import baseball.controller.BaseballGame;

public class Application {

    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        game.play();
    }
}
