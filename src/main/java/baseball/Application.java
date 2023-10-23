package baseball;

import static baseball.model.constants.GameConstants.RESTART_OPTION;

import baseball.controller.BaseballGame;
import baseball.model.domain.Restart;
import baseball.model.service.RestartOptionValidator;
import baseball.model.service.RestartOptionValidatorImp;
import baseball.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        do {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.start();
        } while (setRestart());
    }

    public static boolean setRestart() {
        RestartOptionValidator restartOptionValidator = new RestartOptionValidatorImp();
        Restart restart = new Restart(InputView.setRestartInput(), restartOptionValidator);
        if (restart.getRestartOption().equals(RESTART_OPTION)) {
            return true;
        }
        return false;
    }
}
