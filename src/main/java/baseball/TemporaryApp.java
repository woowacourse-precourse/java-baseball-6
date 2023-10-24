package baseball;

import controller.BaseballGameStart;
import view.InputView;
import view.OutputView;

import static controller.RestartCheck.offerRestartOrQuit;

public class TemporaryApp {
    public static void main(String[] args) {
        boolean isGameStarted = true;
        BaseballGameStart baseballGameStart = new BaseballGameStart();
        while (isGameStarted) {
            baseballGameStart.start();
            isGameStarted = offerRestartOrQuit();
        }
    }
}
