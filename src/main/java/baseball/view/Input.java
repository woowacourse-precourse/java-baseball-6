package baseball.view;

import static baseball.constant.Message.INPUT_ASK_RESTART_MESSAGE;
import static baseball.constant.Message.INPUT_NUMBER_MESSAGE;

public class Input {

    public void printInputMsg() {
        System.out.println(INPUT_NUMBER_MESSAGE);
    }

    public void printInputRestartMsg() {
        System.out.println(INPUT_ASK_RESTART_MESSAGE);
    }
}
