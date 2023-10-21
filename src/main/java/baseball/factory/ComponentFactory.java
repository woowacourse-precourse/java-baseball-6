package baseball.factory;

import baseball.controller.BaseballController;
import baseball.io.OutputView;

public class ComponentFactory {

    public BaseballController baseballController() {
        return new BaseballController(outputView());
    }

    private OutputView outputView() {
        return new OutputView();
    }
}
