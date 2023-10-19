package baseball;

import baseball.controller.BaseballController;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballController controller = new BaseballController(new OutputView());
        controller.run();
    }
}
