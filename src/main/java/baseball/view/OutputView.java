package baseball.view;

import baseball.domain.Constants;

public class OutputView {

    public static void printStartMessage() {
        System.out.println(Constants.START_MESSAGE);
    }

    public static void printHintMessage(String hint) {
        System.out.println(hint);
    }

    public static void printEndMessage() {
        System.out.println(Constants.GAME_END_MESSAGE);
    }

    public static void printCompletelyEndMessage() {
        System.out.println(Constants.COMPLETELY_EXIT_MESSAGE);
    }

}
