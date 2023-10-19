package baseball;

import baseball.application.RandomNumberGenerator;
import baseball.controller.BaseballGame;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame(new RandomNumberGenerator());
        baseballGame.gameStart();
    }
}
