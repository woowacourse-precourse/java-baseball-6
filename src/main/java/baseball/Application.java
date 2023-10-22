package baseball;

import static baseball.model.constants.Constant.RESTART;

import baseball.controller.NumberBaseball;
import baseball.model.domain.Restart;
import baseball.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        do {
            NumberBaseball numberBaseball = new NumberBaseball();
            numberBaseball.start();
        } while (setRestart());
    }

    public static boolean setRestart() {
        Restart restart = new Restart(InputView.setRestartInput());
        if (restart.getRestartNumber().equals(RESTART)) {
            return true;
        }
        return false;
    }
}
