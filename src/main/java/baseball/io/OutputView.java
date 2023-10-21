package baseball.io;

import baseball.constant.GameMessage;

public class OutputView {

    public void printStartMessage() {
        System.out.println(GameMessage.GAME_START.toValue());
    }

    public void printNumberInputRequest() {
        System.out.print(GameMessage.NUMBER_INPUT_REQUEST.toValue());
    }
}
