package baseball;

import baseball.controller.GameController;
import baseball.convertor.InputConvertor;
import baseball.domain.game.ComputerNumberGenerator;
import baseball.util.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView(outputView);
        InputConvertor inputConvertor = new InputConvertor(inputView);
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(1, 9);
        ComputerNumberGenerator randomComputerNumberGenerator = new ComputerNumberGenerator(
                randomNumberGenerator);
        GameController gameController = new GameController(outputView, inputConvertor, randomComputerNumberGenerator);
        gameController.start();
    }
}
