package baseball;

import baseball.controller.Game;

public class Application {

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
