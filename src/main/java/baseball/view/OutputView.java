package baseball.view;

import baseball.constant.OutputMessage;

public class OutputView {

    public void printStartMessage() {
        System.out.println(OutputMessage.GAME_START.getMessage());
    }

    public void printInputGuide() {
        System.out.print(OutputMessage.PLAYER_INPUT_GUIDE.getMessage());
    }
}
