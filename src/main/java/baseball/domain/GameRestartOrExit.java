package baseball.domain;

import static baseball.constant.GameConstant.RESTART_VALUE;
import static baseball.validator.GameValidator.restartOrExitValueValidate;

/**
 * 게임 재시작 , 종료 결정 도메인
 */

public class GameRestartOrExit {
    private String restartOrExit = "";

    public void gameRestartOrValueInput(String restartOrExit) {
        restartOrExitValueValidate(restartOrExit);
        this.restartOrExit = restartOrExit;
    }

    public boolean restartOrExitCheck() {
        return restartOrExit.equals(RESTART_VALUE);
    }

}
