package baseball.console;

import static baseball.console.Constant.INPUT_BASEBALL_GAME_NUMBERS_MESSAGE;
import static baseball.console.Constant.INPUT_BASEBALL_GAME_RESTART_MESSAGE;
import static baseball.console.Constant.START_BASEBALL_GAME_MESSAGE;
import static baseball.console.Constant.TERMINATION_BASEBALL_GAME_MESSAGE;

public class Output {

    public static void printBaseballGameStart() {
        System.out.println(START_BASEBALL_GAME_MESSAGE);
    }
    static void printBaseballGameNumberRequest() {
        System.out.print(INPUT_BASEBALL_GAME_NUMBERS_MESSAGE);
    }

    public static void printBaseballGameHint(String result) {
        System.out.println(result);
    }

    public static void printBaseballGameTermination() {
        System.out.println(TERMINATION_BASEBALL_GAME_MESSAGE);
    }

    static void printBaseballGameRestartNumberRequest() {
        System.out.println(INPUT_BASEBALL_GAME_RESTART_MESSAGE);
    }
}
