package baseball.view;

import static baseball.view.OutputMessage.*;

public class OutputView {
    public void startGame() {
        System.out.println(GAME_START);
    }

    public void endGame() {
        System.out.println(GAME_END);
    }

    public void writeMessage(final String message) {
        System.out.println(message);
    }
}
