package baseball;

import static baseball.ui.GameOutputView.showGameContinueInputMessage;
import static baseball.ui.GameOutputView.showStartMessage;

import baseball.ui.GameInputView;

public class Application {
    public static void main(String[] args) {
        showStartMessage();

        boolean continueGame = true;
        while (continueGame) {
            GameRunner gameRunner = new GameRunner();
            gameRunner.runGameLoop();

            showGameContinueInputMessage();
            continueGame = GameInputView.getContinueInput();
        }
    }
}
