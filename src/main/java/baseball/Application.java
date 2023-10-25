package baseball;

import controller.BaseballGameStart;


import static controller.RestartCheck.offerRestartOrQuit;

public class Application {
    public static void main(String[] args) {
        boolean isGameStarted = true;
        BaseballGameStart baseballGameStart = new BaseballGameStart();

        while (isGameStarted) {
            baseballGameStart.start();
            isGameStarted = offerRestartOrQuit();
        }
    }

}
