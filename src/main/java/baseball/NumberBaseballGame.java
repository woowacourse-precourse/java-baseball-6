package baseball;

import baseball.constant.GameMessage;

public class NumberBaseballGame {
    private Computer computer;
    private Player player;
    private Checker checker;

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

        checker = new Checker(computer.getComputerNumber(), player.getPlayerNumber(), computer.getUsedArray());
        boolean isCorrect = checker.checkAnswer();
    }

    private void printStartMessage() {
        System.out.println(GameMessage.START_MESSAGE);
    }
}
