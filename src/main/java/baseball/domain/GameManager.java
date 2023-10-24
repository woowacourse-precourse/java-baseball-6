package baseball.domain;

import baseball.console.Input;
import baseball.console.Output;

public class GameManager {

    public void run() {
        Output.printBaseballGameStart();
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
