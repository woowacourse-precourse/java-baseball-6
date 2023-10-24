package baseball;

import baseball.controller.GameController;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        GameController gameController = new GameController(inputView, outputView);

        gameController.playGame();
    }
}
