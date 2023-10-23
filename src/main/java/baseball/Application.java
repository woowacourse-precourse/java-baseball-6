package baseball;

import baseball.controller.GameInitializer;

public class Application {
    public static void main(String[] args) {
        GameInitializer gameInitializer = new GameInitializer();
        gameInitializer.startGame();
    }
}
