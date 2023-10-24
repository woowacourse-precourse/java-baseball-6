package baseball;

import baseball.controller.BaseballGame;
import camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;


public class Application {

    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.runGame();
    }
}
