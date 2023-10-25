package baseball;

import baseball.controller.GameController;
import baseball.service.NumberMatcher;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {

    public static void main(String[] args) {

        NumberMatcher numberMatcher = new NumberMatcher();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        GameController gameController = new GameController(numberMatcher, inputView, outputView);

        gameController.gameStart();
    }
}
