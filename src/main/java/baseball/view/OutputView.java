package baseball.view;

import static baseball.view.Messages.GAME_OVER_MESSAGE;
import static baseball.view.Messages.GAME_START_MESSAGE;
import static baseball.view.Messages.INSERT_COMMAND_MESSAGE;
import static baseball.view.Messages.INSERT_NUMBER_MESSAGE;

public class OutputView {
    public void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printHint(String hint) {
        System.out.println(hint);
    }

    public void printGameOver() {
        System.out.println(GAME_OVER_MESSAGE);
    }

    public void printInsertNumbers() {
        System.out.println(INSERT_NUMBER_MESSAGE);
    }

    public void printInsertCommand() {
        System.out.println(INSERT_COMMAND_MESSAGE);
    }
}
