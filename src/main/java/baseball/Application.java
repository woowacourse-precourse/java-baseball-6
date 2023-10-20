package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Application {
    private static int playDecision = 0;
    private static int strike =0;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        game.run();
    }



}
