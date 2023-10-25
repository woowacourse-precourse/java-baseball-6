package baseball;

import baseball.baseballGame.BaseballGame;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.playWholeGame();
    }
}