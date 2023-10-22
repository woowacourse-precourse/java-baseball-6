package baseball;

import baseball.controller.GameController;
import baseball.domain.RandomBallNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        RandomBallNumberGenerator randomBallNumberGenerator = new RandomBallNumberGenerator();
        GameController gameController = new GameController(outputView, inputView, randomBallNumberGenerator);
        gameController.start();
    }
}
