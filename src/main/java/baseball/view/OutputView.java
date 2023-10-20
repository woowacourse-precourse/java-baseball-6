package baseball.view;

import static baseball.view.Messages.GAME_START_MESSAGE;

public class OutputView {
    public void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printHint(String hint) {
        System.out.println(hint);
    }
}
