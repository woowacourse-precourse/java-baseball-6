package baseball.view;

import static baseball.constant.SystemMessage.GAME_END;
import static baseball.constant.SystemMessage.GAME_RESTART;
import static baseball.constant.SystemMessage.TYPE_NUMBER;

import baseball.domain.Hint;

public class OutputView {

    private static final OutputView instance = new OutputView();

    private OutputView() {

    }

    public static OutputView getInstance() {
        return instance;
    }

    public void printReadMessage() {
        System.out.print(TYPE_NUMBER.getMessage());
    }

    public void printHintMessage(Hint hint) {
        System.out.println(hint.toString());

        if (hint.isThreeStrike()) {
            printGameEndMessage();
        }
    }

    private void printGameEndMessage() {
        System.out.println(GAME_END.getMessage());
        printRestartMessage();
    }

    public void printRestartMessage() {
        System.out.println(GAME_RESTART.getMessage());
    }

}
