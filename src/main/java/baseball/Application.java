package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import controller.BaseballGameStart;


import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Objects;

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
