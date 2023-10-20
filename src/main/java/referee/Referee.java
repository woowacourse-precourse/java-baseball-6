package referee;

import camp.nextstep.edu.missionutils.Console;
import message.Message;
import player.Computer;
import player.Player;
import score.Score;
import utils.BaseballRules;

public class Referee {

    private final Computer computer = new Computer();
    private final Player player = new Player();
    private final Score score = new Score();

    private static final String START = "1";
    private static final String END = "2";

    public void playBall() {
        computer.generateComputerRandomNumber();

        do {
            Message.printIntegerInputFromUserMessage();
            score.clearStrikeAndBall();
            player.inputPlayerNumber();
            score.setStrikeAndBall(player.getPlayerBaseballNumber(), computer.getComputerBaseballNumber());
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
