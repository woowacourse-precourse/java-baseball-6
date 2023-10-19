package baseball;

import baseball.controller.GameController;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController();

        OutputView.printStart();
        do{
            gameController.start();
        } while (gameController.isReset());
    }
}
