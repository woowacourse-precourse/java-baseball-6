package baseball;

import baseball.entity.GameImpl;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        View.StartGame();
        GameImpl gameImpl = new GameImpl();
        gameImpl.run();
        Console.close();
    }
}
