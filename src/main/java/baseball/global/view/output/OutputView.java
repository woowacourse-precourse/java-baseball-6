package baseball.global.view.output;

import static baseball.global.message.InGameMessage.*;

public final class OutputView {

    public static void printStartMessage() {
        System.out.println(START_BASEBALL.getMessage());
    }

    public static void printInputThreeNumber() {
        System.out.print(INPUT_THREE_NUMBER.getMessage());
    }

    public static void printPlayerResult(String playerResult) {
        System.out.println(playerResult);
    }

    public static void printThreeStrike() {
        System.out.println(THREE_NUMBER_ALL_MATCH.getMessage());
    }

    public static void printRetryMessage() {
        System.out.println(RETRY_MESSAGE.getMessage());
    }
}
