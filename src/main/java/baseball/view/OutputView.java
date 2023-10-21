package baseball.view;

import baseball.util.ConsoleMessage;

public class OutputView {
    public static void printGameStart() {
        System.out.println(ConsoleMessage.DISPLAY_GAME_START);
    }

    public static void printRoundResult(String result) {
        System.out.println(result);
    }

    public static void printGameSuccess() {
        System.out.println(ConsoleMessage.DISPLAY_GAME_SUCCESS);
    }

}
