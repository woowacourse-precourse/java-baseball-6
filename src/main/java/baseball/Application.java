package baseball;

import baseball.controller.Controller;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller(new OutputView(), new InputView());
        controller.start();
    }
}
