package baseball;

import baseball.controller.GameController;
import baseball.service.GameService;

public class Application {

    public static void main(String[] args) {
        GameController game = new GameController(new GameService());
        game.play();
    }
}