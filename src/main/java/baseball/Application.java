package baseball;

import baseball.controller.GameController;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.startGame();
    }
}
