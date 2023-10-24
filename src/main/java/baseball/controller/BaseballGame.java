package baseball.controller;

import baseball.constant.ApplicationConstant;
import baseball.process.BaseballProcess;

public class BaseballGame {

    private final BaseballProcess baseballProcess = BaseballProcess.of();

    public void run() {
        baseballProcess.start();
        stop();
    }

    public void stop() {
        System.out.println(ApplicationConstant.STOP_GAME_MESSAGE);
    }
}
