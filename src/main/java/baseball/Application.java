package baseball;

import baseball.application.NumberService;
import baseball.controller.GameController;
import baseball.view.ViewService;

public class Application {
    public static void main(String[] args) {
        GameController controller = new GameController(new NumberService(), new ViewService());
        controller.startGame();
    }
}
