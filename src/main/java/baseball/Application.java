package baseball;

import baseball.controller.Controller;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        Controller controller = new Controller(new InputView(outputView), outputView);
        controller.start();
    }
}
