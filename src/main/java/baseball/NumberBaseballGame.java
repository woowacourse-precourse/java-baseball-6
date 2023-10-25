package baseball;

import baseball.constant.GameMessage;

public class NumberBaseballGame {
    private Computer computer;
    private Player player;
    private Checker checker;
    private boolean restartFlag;

    public void start() {
        printStartMessage();
        restartFlag = true;
        play();
    }

    private void play() {
        computer = new Computer();
        computer.generateComputerNumber();

        player = new Player();

        for (; restartFlag; ) {
            System.out.print(GameMessage.PLAYER_INPUT_MESSAGE);
            player.generatePlayerNumber();

            checker = new Checker(computer.getComputerNumber(), player.getPlayerNumber(), computer.getUsedArray());
            boolean isCorrect = checker.checkAnswer();
            checker.printResult();

            if (isCorrect) {
                System.out.println(GameMessage.CORRECT_MESSAGE);
                System.out.println(GameMessage.RESTART_MESSAGE);
                restartFlag = player.restartOrEnd();
                if (restartFlag) {
                    play();
                } else {
                    return;
                }
            }
        }
    }

    private void printStartMessage() {
        System.out.println(GameMessage.START_MESSAGE);
    }
}
