package baseball.view;

import baseball.constants.OutputMessage;

public class OutputView {
    public static void printGameStartMessage() {
        System.out.println(OutputMessage.GAME_START);
    }

    public static void printResult(String result) {
        System.out.println(result);
    }

    public static void printGameExitMessage() {
        System.out.println(OutputMessage.GAME_EXIT);
    }
}