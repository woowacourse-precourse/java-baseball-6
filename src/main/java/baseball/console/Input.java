package baseball.console;

import static baseball.console.Constant.INPUT_BASEBALL_GAME_NUMBERS_MESSAGE;
import static baseball.console.Constant.INPUT_BASEBALL_GAME_RESTART_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String receiveBaseballNumber() {
        System.out.print(INPUT_BASEBALL_GAME_NUMBERS_MESSAGE);
        return Console.readLine();
    }

    public static String receiveRestartNumber() {
        System.out.println(INPUT_BASEBALL_GAME_RESTART_MESSAGE);
        return Console.readLine();
    }
}
