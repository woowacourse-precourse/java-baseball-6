package baseball;

import baseball.controller.BaseballController;
import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.service.BaseballService;
import baseball.view.console.InputView;
import baseball.view.console.OutputView;

public class Application {
    public static void main(String[] args) {
        BaseballService baseballService = new BaseballService(
                new Player(),
                new Computer()
        );
        BaseballController baseballController = new BaseballController(
                new InputView(),
                new OutputView(),
                baseballService
        );

        baseballController.printGameStartMessage();

        while (true) {
            baseballController.playGame();
            if (!baseballController.isRetry()) {
                break;
            }
        }

    }
}
