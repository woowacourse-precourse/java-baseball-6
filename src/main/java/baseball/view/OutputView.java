package baseball.view;

import static baseball.view.OutputMessage.GAME_END;
import static baseball.view.OutputMessage.GAME_START;

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
