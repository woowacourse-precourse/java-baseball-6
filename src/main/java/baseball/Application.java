package baseball;

import baseball.controller.BaseballGame;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.gameStart();
    }
}
