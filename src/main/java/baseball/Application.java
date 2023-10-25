package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    static GameService gameService = new GameService();

    public static void main(String[] args) {
        gameService.startGame();
    }
}
