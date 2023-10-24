package baseball.view;

import baseball.util.GameMessage;

public class OutputView {
    public static void printGameStart() {
        System.out.println(GameMessage.DISPLAY_GAME_START);
    }

    public static void printRoundResult(String result) {
        System.out.println(result);
    }

    public static void printGameSuccess() {
        System.out.println(GameMessage.DISPLAY_GAME_SUCCESS);
    }

}
