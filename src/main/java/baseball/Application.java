package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        GameInitializer gameInitializer = new GameInitializer();
        gameInitializer.initializeGame();
        Console.close();
    }
}