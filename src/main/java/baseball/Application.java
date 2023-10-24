package baseball;

import baseball.controller.BaseballController;
import baseball.view.ConsolePrint;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballController controller = new BaseballController();
        controller.init();
        ConsolePrint.init();
    }
}
