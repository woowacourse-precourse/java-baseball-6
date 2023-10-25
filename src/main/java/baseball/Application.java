package baseball;

import baseball.controller.GameController;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        GameController gameController = new GameController(outputView);

        gameController.startGame();
    }
}
