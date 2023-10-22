package referee;

import static constant.BaseballConstant.END;
import static constant.BaseballConstant.START;
import static utils.BaseballRules.isThreeStrike;

import camp.nextstep.edu.missionutils.Console;
import message.Message;
import player.BaseballPlayer;
import score.BaseballScore;

public class Referee {

    private final BaseballPlayer computer;
    private final BaseballPlayer user;
    private final BaseballScore score;

    public Referee(BaseballPlayer computer, BaseballPlayer user, BaseballScore score) {
        this.computer = computer;
        this.user = user;
        this.score = score;
    }

    public void playBall() {
        computer.inputBaseballNumbers();

        do {
            baseballFlow();
        } while (!isThreeStrike(score.getStrike()));

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
