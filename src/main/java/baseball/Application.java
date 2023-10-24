package baseball;

import baseball.Controller.GameController;

public class Application {
    public static void main(String[] args) {
        GameController gc = new GameController();
        gc.run();
    }
}
