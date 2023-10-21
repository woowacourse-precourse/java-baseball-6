package baseball;

import baseball.controller.NumberBaseballController;
import baseball.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        NumberBaseballController numberBaseballController = new NumberBaseballController();
        numberBaseballController.run();
    }
}
