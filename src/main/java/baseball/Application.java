package baseball;

import baseball.controller.NumberBaseballController;
import baseball.model.NumberBaseball;
import baseball.service.NumberBaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        NumberBaseballController numberBaseballController = new NumberBaseballController(new InputView(), new OutputView(), new NumberBaseballService());
        numberBaseballController.run();
    }
}
