package referee;

import camp.nextstep.edu.missionutils.Console;
import hint.Hint;
import java.util.List;
import message.Message;
import player.Computer;
import player.Player;

public class Referee {
    private Computer computer;
    private Player player;
    private static final String START = "1";
    private static final String END = "2";

    public void playBall() {
        computer = new Computer();
        player = new Player();

        do {
            Message.printIntegerInputFromUserMessage();
            player.inputPlayerNumber();
            List<Integer> playerBaseballNumber = player.getPlayerBaseballNumber();
            List<Integer> computerBaseballNumber = computer.getComputerBaseballNumber();
            int[] score = Hint.calculateStrikeAndBall(playerBaseballNumber, computerBaseballNumber);
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
