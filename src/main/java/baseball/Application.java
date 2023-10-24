package baseball;

import controller.GameController;

public class Application {
    public static void main(String[] args) {
        GameController game = new GameController();
        game.proceedGame();
    }
}
