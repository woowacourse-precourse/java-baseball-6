package baseball;

import controller.NumberBaseballController;
import model.system.GameController;
import model.system.GameStarter;
import model.system.GameTerminator;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController(new GameStarter(), new GameTerminator());
        NumberBaseballController numberBaseBallController = new NumberBaseballController(gameController);
        numberBaseBallController.run();
    }
}
