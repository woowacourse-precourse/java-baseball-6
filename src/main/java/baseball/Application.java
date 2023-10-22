package baseball;

import baseball.controller.GameController;
import baseball.domain.ComputerNumberGenerator;
import baseball.util.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView(outputView);
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(1, 9);
        ComputerNumberGenerator randomComputerNumberGenerator = new ComputerNumberGenerator(
                randomNumberGenerator);
        GameController gameController = new GameController(outputView, inputView, randomComputerNumberGenerator);
        gameController.start();
    }
}
