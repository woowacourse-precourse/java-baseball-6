package baseball.view;

import static baseball.enums.Message.END_MESSAGE;
import static baseball.enums.Message.NOTHING;
import static baseball.util.PrintUtils.println;

import baseball.model.Score;
import baseball.enums.Message;
import baseball.util.PrintUtils;

public class OutputView {
    public void printMessage(Message message) {
        PrintUtils.printMessage(message);
    }

    public void printScoreBoardMessageFrom(Score score) {
        if (score.isNothing()) {
            printMessage(NOTHING);
            return;
        }
        println(score.getScoreBoardMessage());
    }

    public void printIfStrikeOutFrom(Score score) {
        if (score.isStrikeOut()) {
            printMessage(END_MESSAGE);
        }
    }
}
