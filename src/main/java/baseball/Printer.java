package baseball;

public class Printer {

    public static void printGameStart() {
        System.out.println(Constant.GAME_START_MESSAGE);
    }

    public static void printInputNumber() {
        System.out.print(Constant.INPUT_NUMBER_MESSAGE);
    }

    public static void printHint(Hint hint) {
        System.out.println(hint.getHint());
    }

    public static void printGameWin() {
        System.out.println(Constant.GAME_WIN_MESSAGE);
    }

    public static void printGameRestartOrQuit() {
        System.out.println(Constant.GAME_RESTART_OR_QUIT_MESSAGE);
    }
}
