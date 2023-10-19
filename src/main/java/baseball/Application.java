package baseball;

import controller.BaseballController;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballController baseballController = new BaseballController();
        baseballController.startBaseball();

        while(true) {
            baseballController.getUserNumber();
        }

    }
}
