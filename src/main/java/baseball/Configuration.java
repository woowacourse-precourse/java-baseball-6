package baseball;

import baseball.controller.BaseballController;
import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.Result;
import baseball.exception.InputValidator;
import baseball.service.BaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Configuration {
    public static BaseballController baseballController() {
        BaseballController baseballController = new BaseballController(
                new InputView(),
                new OutputView(),
                baseballService()
        );
        return baseballController;
    }

    public static BaseballService baseballService() {
        return new BaseballService(
                new Computer(),
                new Player(),
                new Result(),
                new InputValidator()
        );
    }
}