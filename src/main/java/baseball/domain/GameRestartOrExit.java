package baseball.domain;

import static baseball.constant.GameConstant.RESTART_VALUE;
import static baseball.validator.GameValidator.restartOrExitValueValidate;

public class GameRestartOrExit {
    private final String restartOrExit;

    public GameRestartOrExit(String restartOrExit) {
        restartOrExitValueValidate(restartOrExit);
        this.restartOrExit = restartOrExit;
    }

    public boolean restartOrExitCheck() {
        return restartOrExit.equals(RESTART_VALUE);
    }

}
