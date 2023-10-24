package baseball;

import baseball.controller.GameController;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        GameController.proceedGame();
    }
}
