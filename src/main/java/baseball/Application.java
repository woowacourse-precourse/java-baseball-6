package baseball;

import static baseball.ui.GameOutputView.showGameContinueInputMessage;
import static baseball.ui.GameOutputView.showStartMessage;

import baseball.ui.GameInputView;

public class Application {
    public static void main(String[] args) {
        showStartMessage();

        boolean continueGame = true;
        while (continueGame) {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.run();

            showGameContinueInputMessage();
            continueGame = GameInputView.getContinueInput();
        }
    }
}
