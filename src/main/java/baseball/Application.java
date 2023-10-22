package baseball;

import static baseball.ui.GameOutput.showGameContinueInputMessage;
import static baseball.ui.GameOutput.showStartMessage;

import baseball.ui.GameInput;

public class Application {
    public static void main(String[] args) {
        showStartMessage();

        boolean continueGame = true;
        while (continueGame) {
            GameRunner gameRunner = new GameRunner();
            gameRunner.runGameLoop();

            showGameContinueInputMessage();
            continueGame = GameInput.getContinueInput();
        }
    }
}
