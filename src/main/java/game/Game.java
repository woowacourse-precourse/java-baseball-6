package game;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    static Computer computer;

    public static void run() {
        Game game = new Game();
        do {
            computer = new Computer();
            game.startNewGame();

        } while (game.restart());
    }

    public void startNewGame() {

    }

    public boolean restart() {

        return true;
    }
}

