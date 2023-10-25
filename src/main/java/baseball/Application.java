package baseball;

import baseball.controller.GameController;
import baseball.view.InputView;

public class Application {

    public static void main(String[] args) {
        GameController controller = new GameController(new InputView());
        controller.startGameUntilUserWant();
    }
}
