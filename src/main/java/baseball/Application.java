package baseball;

import baseball.game.GameEngine;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        new GameEngine().playGame();

        Console.close();
    }
}
