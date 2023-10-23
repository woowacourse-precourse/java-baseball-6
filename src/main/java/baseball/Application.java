package baseball;

import baseball.application.NumberService;
import baseball.controller.GameController;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameController controller = new GameController(new NumberService(), new InputView(), new OutputView());
        controller.startGame();
    }
}
