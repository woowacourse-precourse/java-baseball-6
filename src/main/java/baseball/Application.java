package baseball;

import controller.NumberBaseballController;
import model.system.GameController;
import model.system.GameStarter;
import model.system.GameTerminator;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController(new GameStarter(), new GameTerminator());
        NumberBaseballController numberBaseBallController = new NumberBaseballController(gameController,
            new InputView(),
            new OutputView());
        numberBaseBallController.run();
    }
}
