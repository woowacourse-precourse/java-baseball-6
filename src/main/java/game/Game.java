package game;

import camp.nextstep.edu.missionutils.Console;

import static constant.Constant.*;
import static constant.ErrorMessage.*;

public class Game {

    static Computer computer;

    public static void run() {
        Game game = new Game();
        do {
            computer = new Computer();
            game.startNewGame();

        } while (game.restart());
    }

    private void startNewGame() {

    }

    private boolean restart() {
        System.out.println(RESTART_MESSAGE);

        String InputString = Console.readLine();
        if (InputString.equals(RESTARTING_INPUT)) {
            return true;
        } else if (InputString.equals(TERMINATING_INPUT)) {
            return false;
        }

        throw new IllegalArgumentException(wrongInput);
    }
}

