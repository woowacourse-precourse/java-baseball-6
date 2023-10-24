package baseball.controller;

import baseball.domain.GameSetting;
import camp.nextstep.edu.missionutils.Console;

import static baseball.constant.GameConstant.RESTART_OR_EXIT_PROMPT;

public class GameRestarter {
    private final GameSetting gameSetting;

    public GameRestarter(GameSetting gameSetting) {
        this.gameSetting = gameSetting;
    }

    public boolean restartOrExit() {
        System.out.println(RESTART_OR_EXIT_PROMPT);
        String input = Console.readLine();
        return gameSetting.getInputService().restart(input, gameSetting.getRestartNum(), gameSetting.getExitNum());
    }
}
