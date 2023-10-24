package baseball.console;

import baseball.console.game.GameList;
import baseball.console.game.numberbaseball.NumberBaseballGame;
import baseball.console.config.ConsoleMessage;
import baseball.console.config.ConsoleStatus;
import camp.nextstep.edu.missionutils.Console;

public class GameConsole {
    ConsoleStatus status;
    GameList target;
    NumberBaseballGame numberBaseballGame;

    public GameConsole() {
        init();
    }

    private void init() {
        status = ConsoleStatus.CONTINUE;
        target = GameList.NUMBER_BASEBALL;
    }

    public void start() {
        while (status == ConsoleStatus.CONTINUE) {
            if (target == GameList.NUMBER_BASEBALL) {
                launchNumberBaseball();
            }
            confirmStatus();
        }
    }

    private void launchNumberBaseball() {
        printConsoleMessage(ConsoleMessage.NUMBER_BASEBALL_GAME_START);
        numberBaseballGame = new NumberBaseballGame();
        numberBaseballGame.start();
    }

    private void confirmStatus() {
        printConsoleMessage(ConsoleMessage.CONTINUE_OR_EXIT);
        int choice = Integer.parseInt(Console.readLine());
        status = ConsoleStatus.values()[choice];
    }

    private void printConsoleMessage(String message) {
        System.out.println(message);
    }

}
