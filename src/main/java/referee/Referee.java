package referee;

import camp.nextstep.edu.missionutils.Console;
import hint.Hint;
import message.Message;
import player.Computer;
import player.Player;

public class Referee {
    Computer computer;
    Player player;
    Hint hint;
    private final static String START = "1";
    private final static String END = "2";

    public void playBall() {
        computer = new Computer();
        player = new Player();
        hint = new Hint();

        do {
            Message.printIntegerInputFromUserMessage();
            player.inputPlayerNumber();
            int[] score = hint.calculateStrikeAndBall(player.getPlayerBaseballNumber(),
                    computer.getComputerBaseballNumber());
            Message.printHintMessage(score);
        } while (!isThreeStrike());

        Message.printThreeStrikeMessage();
        continueOrFinish();
    }

    public void continueOrFinish() {
        Message.printContinueOrFinishMessage();
        String userInput = Console.readLine();
        if (userInput.equals(START)) {
            playBall();
        }
        if (userInput.equals(END)) {
            Message.printEndGameMessage();
        }
    }

    private boolean isThreeStrike() {
        return player.getPlayerBaseballNumber().equals(computer.getComputerBaseballNumber());
    }


}
