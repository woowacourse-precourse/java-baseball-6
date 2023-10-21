package baseball.console;

import baseball.console.game.GameList;
import baseball.console.game.numberbaseball.NumberBaseballGame;
import baseball.console.util.ConsoleMessage;
import baseball.console.util.ConsoleStatus;
import camp.nextstep.edu.missionutils.Console;

import static baseball.console.util.ConsoleMessage.*;

public class GameConsole {
    NumberBaseballGame numberBaseballGame;
    ConsoleStatus consoleStatus;
    GameList target;

    public GameConsole() {
        init();
    }

    private void init() {
        target = GameList.NUMBER_BASEBALL;
        consoleStatus = ConsoleStatus.CONTINUE;
    }

    public void start() {
        while (consoleStatus == ConsoleStatus.CONTINUE) {
            if (target == GameList.NUMBER_BASEBALL) {
                printConsoleMessage(NUMBER_BASEBALL_GAME_START);
                launchNumberBaseball();
            }
            printConsoleMessage(CONTINUE_OR_EXIT);
            int choice = Integer.parseInt(Console.readLine());
            consoleStatus = ConsoleStatus.values()[choice];
        }

    }

    private void printConsoleMessage(String message) {
        System.out.println(message);
    }

    private void launchNumberBaseball() {
        numberBaseballGame = new NumberBaseballGame();
        numberBaseballGame.start();
    }
}
