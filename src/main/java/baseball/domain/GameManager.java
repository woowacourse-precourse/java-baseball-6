package baseball.domain;

import baseball.console.Input;
import baseball.console.Output;

public class GameManager {

    public GameManager() {
        Output.printBaseballGameStart();
    }

    public void run() {
        do {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.playGame();
        } while (isRestart());
    }

    private boolean isRestart() {
        String isRestart = Input.receiveRestartNumber();
        TerminationManager terminationManager = new TerminationManager(isRestart);
        return terminationManager.isRestart();
    }
}
