package baseball;

import baseball.controller.BaseballGame;

public class Application {
    // 게임 시작
    public static void main(String[] args) {
        BaseballGame baseballGame = BaseballGame.getInstance();
        baseballGame.runGame();
    }
}