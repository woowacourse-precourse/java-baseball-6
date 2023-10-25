package baseball;

import baseball.system.GameSystem;

public class Application {
    public static void main(String[] args) {
        GameSystem game = new GameSystem();
        game.start();
    }
}