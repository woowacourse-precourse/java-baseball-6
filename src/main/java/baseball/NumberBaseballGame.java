package baseball;

import baseball.constant.GameMessage;

public class NumberBaseballGame {
    public void start() {
        printStartMessage();
        play();
    }

    private void play() {
    }

    private void printStartMessage() {
        System.out.println(GameMessage.START_MESSAGE);
    }
}
