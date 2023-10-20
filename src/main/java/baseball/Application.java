package baseball;

import cotroller.GameController;

public class Application {
    public static void main(String[] args) {
        GameController game = new GameController();
        game.run();
    }
}
