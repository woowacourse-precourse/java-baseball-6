package baseball;

import baseball.constant.GameMessage;

public class NumberBaseballGame {
    private Computer computer;
    private Player player;

    public void start() {
        printStartMessage();
        play();
    }

    private void play() {
        computer = new Computer();
        computer.generateComputerNumber();

        player = new Player();
        System.out.print(GameMessage.PLAYER_INPUT_MESSAGE);
        player.generatePlayerNumber();
    }

    private void printStartMessage() {
        System.out.println(GameMessage.START_MESSAGE);
    }
}
