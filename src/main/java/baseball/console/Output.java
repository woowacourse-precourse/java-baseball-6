package baseball.console;

public class Output {

    public static void printBaseballGameStart() {
        System.out.println(Constant.START_BASEBALL_GAME_MESSAGE);
    }

    static void printBaseballGameNumberRequest() {
        System.out.print(Constant.INPUT_BASEBALL_GAME_NUMBERS_MESSAGE);
    }

    public static void printBaseballGameHint(String result) {
        System.out.println(result);
    }

    public static void printBaseballGameTermination() {
        System.out.println(Constant.TERMINATION_BASEBALL_GAME_MESSAGE);
    }

    static void printBaseballGameRestartNumberRequest() {
        System.out.println(Constant.INPUT_BASEBALL_GAME_RESTART_MESSAGE);
    }
}
