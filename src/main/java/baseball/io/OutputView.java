package baseball.io;

import baseball.constant.GameMessage;

public class OutputView {

    public void printStartMessage() {
        System.out.println(GameMessage.GAME_START.toValue());
    }
}
