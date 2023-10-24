package baseball;

import baseball.controller.GameController;

public class Application {

    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.run();
    }

}
