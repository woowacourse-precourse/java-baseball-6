package referee;

import camp.nextstep.edu.missionutils.Console;
import hint.Hint;
import java.util.List;
import message.Message;
import player.Computer;
import player.Player;
import utils.BaseballRules;

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
        } while (!BaseballRules.isThreeStrike(player.getPlayerBaseballNumber(), computer.getComputerBaseballNumber()));

        Message.printThreeStrikeMessage();
        continueOrFinish();
    }

    private void continueOrFinish() {
        Message.printContinueOrFinishMessage();
        String userInput = Console.readLine();

        if (userInput.equals(START)) {
            playBall();
        }
        if (userInput.equals(END)) {
            Message.printEndGameMessage();
        }
    }
}
