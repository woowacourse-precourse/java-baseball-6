package controller;

import process.BaseballProcess;

public class BaseballGame {

    final BaseballProcess baseballProcess = BaseballProcess.of();

    public void run() {
        baseballProcess.playGame();
    }
}
