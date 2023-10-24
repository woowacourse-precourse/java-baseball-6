package baseball.view;

import static baseball.Config.*;

public class OutputView {
    public void gameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void gameEnd() {
        System.out.println(GAME_END_MESSAGE);
    }

    public void numberResult(String result) {
        System.out.println(result);
    }
}
