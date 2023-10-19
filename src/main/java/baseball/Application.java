package baseball;

import baseball.controller.GameController;
import baseball.domain.User;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        GameController gameController = new GameController();

        gameController.start();

        gameController.play(inputView.readUserBaseballNumber());
    }

}
