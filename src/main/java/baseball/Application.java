package baseball;

import baseball.game.GameRunner;

public class Application {
    public static void main(String[] args) {
        GameRunner gameRunner = new GameRunner();
        gameRunner.run();
    }
}
