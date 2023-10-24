package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        GameManager game = new GameManager();
        game.gameInit();
        game.startGames();
    }
}
