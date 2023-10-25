package baseball;

import baseball.Controller.BaseballGameController;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Application {
    public static void main(String[] args) {
        BaseballGameController controller = new BaseballGameController();
        controller.startGame();
    }
}

