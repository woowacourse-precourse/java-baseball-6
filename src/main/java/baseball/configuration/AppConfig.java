package baseball.configuration;

import baseball.controller.BaseballController;
import baseball.service.NumbersGenerator;
import baseball.view.InputView;
import baseball.view.InputViewValidator;

public class AppConfig {
    public BaseballController baseballController() {
        return new BaseballController(new InputView(new InputViewValidator()), new NumbersGenerator());
    }
}
