package baseball;

import controller.BaseBallController;
import view.Input;
import service.BaseBallService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        BaseBallController controller = new BaseBallController(new Input(), new BaseBallService());

        controller.startGame();

    }
}
