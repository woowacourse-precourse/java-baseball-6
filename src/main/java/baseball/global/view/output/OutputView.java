package baseball.global.view.output;

import static baseball.global.message.InGameMessage.*;

public class OutputView {

    public void printStartMessage() {
        System.out.println(START_BASEBALL.getMessage());
    }

    public void printInputThreeNumber() {
        System.out.print(INPUT_THREE_NUMBER.getMessage());
    }

    public void printPlayerResult(String playerResult) {
        System.out.println(playerResult);
    }

    public void printThreeStrike() {
        System.out.println(THREE_NUMBER_ALL_MATCH.getMessage());
    }

    public void printRetryMessage() {
        System.out.println(RETRY_MESSAGE.getMessage());
    }
}
