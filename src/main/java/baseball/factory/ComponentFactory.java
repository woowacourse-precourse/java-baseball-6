package baseball.factory;

import baseball.controller.BaseballController;
import baseball.io.OutputView;
import baseball.service.BaseballService;
import baseball.utils.RandomNumberGenerator;

public class ComponentFactory {

    public BaseballController baseballController() {
        return new BaseballController(outputView(), baseballService());
    }

    private BaseballService baseballService() {
        return new BaseballService(randomNumberGenerator());
    }

    private RandomNumberGenerator randomNumberGenerator() {
        return new RandomNumberGenerator();
    }

    private OutputView outputView() {
        return new OutputView();
    }
}
