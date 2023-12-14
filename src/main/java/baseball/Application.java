package baseball;

import baseball.controller.GameManager;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        gameManager.run();
        Console.close();
    }
}
