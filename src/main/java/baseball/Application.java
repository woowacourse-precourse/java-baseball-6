package baseball;

import baseball.Controller.GameManager;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static final int NUM_DIGITS = 3;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new GameManager().playGame();
    }
}
