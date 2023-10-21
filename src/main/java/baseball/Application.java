package baseball;

import baseball.controller.Controller;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller(initInputView(), initOutputView());
        controller.run();
    }

    private static InputView initInputView() {
        return new InputView();
    }

    private static OutputView initOutputView() {
        return new OutputView();
    }
}
