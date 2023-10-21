package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Application {
    private static ArrayList<Integer> answer;

    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.start();
    }
}
