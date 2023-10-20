package referee;

import static constant.NumberConstant.END;
import static constant.NumberConstant.START;

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

        if (Integer.parseInt(userInput) == START) {
            playBall();
            return;
        }
        if (Integer.parseInt(userInput) == END) {
            Message.printEndGameMessage();
            return;
        }

        Message.printErrorMessage();
        continueOrFinish();
    }
}
