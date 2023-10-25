package baseball;

import baseball.constant.GameMessage;

public class NumberBaseballGame {
    private Computer computer;

    public void start() {
        printStartMessage();
        play();
    }

    private void play() {
        computer = new Computer();
        computer.generateComputerNumber();
    }

    private void printStartMessage() {
        System.out.println(GameMessage.START_MESSAGE);
    }
}
