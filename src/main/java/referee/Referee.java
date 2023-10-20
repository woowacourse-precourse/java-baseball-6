package referee;

import static constant.NumberConstant.END;
import static constant.NumberConstant.START;

import camp.nextstep.edu.missionutils.Console;
import message.Message;
import player.Computer;
import player.User;
import score.Score;
import utils.BaseballRules;

public class Referee {

    private final Computer computer = new Computer();
    private final User user = new User();
    private final Score score = new Score();

    public void playBall() {
        computer.inputBaseballNumber();

        do {
            baseballFlow();
        } while (!BaseballRules.isThreeStrike(user.getBaseballNumber(), computer.getBaseballNumber()));

        Message.printThreeStrikeMessage();
        continueOrFinish();
    }

    private void baseballFlow() {
        Message.printIntegerInputFromUserMessage();
        score.clearStrikeAndBall();
        user.inputBaseballNumber();
        score.setStrikeAndBall(user.getBaseballNumber(), computer.getBaseballNumber());
        Message.printHintMessage(score);
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
