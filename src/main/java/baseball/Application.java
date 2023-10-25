package baseball;

import baseball.controller.GameHandler;
import baseball.service.BaseballGame;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();

        GameHandler gameHandler = GameHandler.from(baseballGame);
        gameHandler.executeGame();
    }
}
