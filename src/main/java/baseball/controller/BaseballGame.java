package baseball.controller;

import baseball.process.BaseballProcess;

public class BaseballGame {

    private final BaseballProcess baseballProcess = BaseballProcess.of();

    public void run() {
        baseballProcess.playGame();
    }
}
