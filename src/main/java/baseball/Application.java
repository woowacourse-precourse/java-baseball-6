package baseball;

//import java.util.List;

import baseball.controller.GameController;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.run();
    }
}
