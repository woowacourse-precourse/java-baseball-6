package referee;

import static constant.NumberConstant.END;
import static constant.NumberConstant.START;

import camp.nextstep.edu.missionutils.Console;
import message.Message;
import player.BaseballPlayer;
import player.Computer;
import player.User;
import score.BaseballScore;
import utils.BaseballRules;

public class Referee {

    private final BaseballPlayer computer = new Computer();
    private final BaseballPlayer user = new User();
    private final BaseballScore score = new BaseballScore();

    public void playBall() {
        computer.inputBaseballNumbers();

        do {
            baseballFlow();
        } while (!BaseballRules.isThreeStrike(user.getBaseballNumbers(), computer.getBaseballNumbers()));

        Message.printThreeStrikeMessage();
        continueOrFinish();
    }

    private void baseballFlow() {
        Message.printIntegerInputFromUserMessage();
        score.clearStrikeAndBall();
        user.inputBaseballNumbers();
        score.calculateStrikeAndBall(user.getBaseballNumbers(), computer.getBaseballNumbers());
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
