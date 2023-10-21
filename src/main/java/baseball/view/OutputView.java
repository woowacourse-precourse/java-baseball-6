package baseball.view;

import baseball.constant.OutputMessage;

public class OutputView {

    public void printStartMessage() {
        System.out.print(OutputMessage.GAME_START.getMessage());
    }
}
