package baseball.view;

import static baseball.enums.Constant.MAX_NUMBER_LENGTH;
import static baseball.enums.Message.GAME_FINISHED_MESSAGE;
import static baseball.enums.Message.GAME_INPUT_NUMBER_MESSAGE;
import static baseball.enums.Message.GAME_RESTART_OR_END_MESSAGE;
import static baseball.enums.Message.GAME_START_MESSAGE;

public class OutputView {

    public void printStartMessage() {
        System.out.println(GAME_START_MESSAGE.getMessage());
    }

    public void printInputNumberMessage() {
        System.out.print(GAME_INPUT_NUMBER_MESSAGE.getMessage());
    }

    public void printFinishMessage() {
        System.out.println(MAX_NUMBER_LENGTH.getConstant() + GAME_FINISHED_MESSAGE.getMessage());
    }

    public void printRestartOrEndMessage() {
        System.out.println(GAME_RESTART_OR_END_MESSAGE.getMessage());
    }

    public void printResult(String result) {
        System.out.println(result);
    }
}
