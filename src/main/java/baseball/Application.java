package baseball;

import baseball.Controller.GameController;
import baseball.View.GameView;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.GameStart();
    }
}