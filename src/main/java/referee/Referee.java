package referee;

import static utils.BaseballRules.isThreeStrike;

import camp.nextstep.edu.missionutils.Console;
import message.Message;
import player.BaseballPlayer;
import score.BaseballScore;

public class Referee {

    private static final String START = "1";
    private static final String END = "2";
    private final BaseballPlayer computer;
    private final BaseballPlayer user;
    private final BaseballScore score;

    public Referee(BaseballPlayer computer, BaseballPlayer user) {
        this.computer = computer;
        this.user = user;
        this.score = new BaseballScore();
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
        score.calculateStrikeAndBall(user.getPlayerBaseballNumbers(),
                computer.getPlayerBaseballNumbers());
        Message.printHintMessage(score);
    }

    private void continueOrFinish() {
        Message.printContinueOrFinishMessage();
        String userInput = Console.readLine();

        if (userInput.equals(START)) {
            playBall();
            return;
        }
        if (userInput.equals(END)) {
            Message.printEndGameMessage();
            return;
        }

        Message.printErrorMessage();
        continueOrFinish();
    }
}
