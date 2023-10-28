package baseball.view;

import baseball.domain.Hint;

import static baseball.constant.SystemMessage.*;

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
    }

    public void printGameEndMessage() {
        System.out.println(GAME_END.getMessage());
        printRestartMessage();
    }

    private void printRestartMessage() {
        System.out.println(GAME_RESTART.getMessage());
    }

}
