package baseball;

import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {

    public static void main(String[] args) {
        Game baseball = new BaseballGame();
        baseball.startGame();
    }
}
