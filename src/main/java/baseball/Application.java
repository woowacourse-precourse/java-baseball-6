package baseball;

import baseball.controller.BaseballController;
import baseball.service.BaseballService;
import baseball.util.BaseballNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BaseballNumberGenerator baseballNumberGenerator = new BaseballNumberGenerator();
        BaseballService baseballService = new BaseballService();
        BaseballController baseballController = new BaseballController(inputView, outputView, baseballNumberGenerator,
                baseballService);

        baseballController.startBaseballGame();

    }
}
