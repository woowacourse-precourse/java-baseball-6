package baseball;

import baseball.game.InputManager;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        InputManager inputManager = new InputManager();

        List<Integer> randNumber = gameManager.createRandNumber();

        inputManager.printInfoMessage();
        String userBaseballNumber = inputManager.requestInput();
    }
}
