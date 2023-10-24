package baseball.controller;

import baseball.model.AnswerNumber;
import baseball.model.Referee;
import baseball.model.UserNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallGame {
    private final AnswerNumber answer;
    private static UserNumber user;
    private final Referee referee;

    public BaseBallGame() {
        answer = new AnswerNumber();
        referee = new Referee();
    }

    public void start() {
        do {
            getNumberFromUser();
            printHint(getHint());
        } while (!isGameSet());
    }

    public boolean isGameSet() {
        if(referee.isThreeStrike()) {
            OutputView.printGameSetMessage();
            return true;
        }
        return false;
    }

    public void getNumberFromUser() {
        user = new UserNumber(InputView.setUserNumber());
        user.getUserNumber();
    }

    public void printHint(int[] hint) {
        printBallHint(hint);
        printStrikeHint(hint);
        printNothingHint(hint);
        printEnter();
    }

    public static void printBallHint(int[] hint) {
        if(hint[0] != 0) {
            if(hint[1] != 0) {
                OutputView.printCount(hint[0]);
                OutputView.printBallStrikeMessage();
            }else{
                OutputView.printCount(hint[0]);
                OutputView.printBallMessage();
            }
        }
    }

    public static void printStrikeHint(int[] hint) {
        if (hint[1] != 0) {
            OutputView.printCount(hint[1]);
            OutputView.printStrikeMessage();
        }
    }

    public static void printNothingHint(int[] hint) {
        if (hint[0] == 0 && hint[1] == 0) {
            OutputView.printNothingMessage();
        }
    }

    public static void printEnter() {
        System.out.println();
    }

    public int[] getHint() {
        return referee.getHint(user.getUserNumber(), answer.getAnswerNumber());
    }
}