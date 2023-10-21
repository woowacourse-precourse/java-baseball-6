package baseball;

import controller.NumberBaseBallController;
import model.system.GameController;
import model.system.GameStarter;
import model.system.GameTerminator;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController(new GameStarter(), new GameTerminator());
        NumberBaseBallController numberBaseBallController = new NumberBaseBallController(gameController);
        numberBaseBallController.run();
    }
}
