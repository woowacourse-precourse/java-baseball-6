package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.initGame();
        Console.close();
    }
}
