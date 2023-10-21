package baseball;

import baseball.controller.Controller;
import baseball.service.Service;
import baseball.view.InputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        new Controller(new InputView(new InputValidator()), new OutputView(), new Service()).run();
    }
}
