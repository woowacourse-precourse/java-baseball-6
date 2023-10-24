package baseball;

import baseball.controller.BaseballGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballGame baseballGame = new BaseballGame();

        do {
            baseballGame.gameStart();
            baseballGame.inGame();
        } while (baseballGame.retryCheck());
    }
}
