package baseball.game;

import baseball.io.Input;
import baseball.io.Input.ContinueOption;
import baseball.io.Output;

public class GameManager {
    private final BaseballGame baseballGame = new BaseballGame();

    public void run() {
        Output.greetingOutput();

        do {
            baseballGame.play();
        } while (shouldContinueGame());
    }

    private boolean shouldContinueGame() {
        ContinueOption continueOption = Input.resumeInput();
        return continueOption == ContinueOption.CONTINUE;
    }
}
