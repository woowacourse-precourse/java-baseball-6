package baseball;

import baseball.logic.BaseballGame;

public class Application {
    public static void main(String[] args) {
        int ballLength = 3;
        BaseballGame baseballGame = new BaseballGame(ballLength);
        baseballGame.run();
    }
}
