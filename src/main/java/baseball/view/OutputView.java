package baseball.view;

import baseball.model.Hint;
import baseball.util.MessageConst;

public class OutputView {

    public void printStartMessage() {
        System.out.println(MessageConst.START_MSG);
    }

    public void printHint(Hint hint) {
        System.out.println(findStatus(hint));
    }

    private String findStatus(Hint hint) {
        if (hint.isOnlyStrike()) {
            return hint.getStrike() + MessageConst.STRIKE;
        }
        if (hint.isOnlyBall()) {
            return hint.getBall() + MessageConst.BALL;
        }
        if (hint.isNothing()) {
            return MessageConst.NOTHING;
        }
        return hint.getBall() + MessageConst.BALL + MessageConst.SPACE + hint.getStrike() + MessageConst.STRIKE;
    }

    public void printCorrectMessage() {
        System.out.println(MessageConst.CORRECT_MSG);
    }
}
