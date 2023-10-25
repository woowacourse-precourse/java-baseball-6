package baseball.util;

import baseball.console.Input;
import baseball.console.Output;
import baseball.domain.BaseballGame;
import baseball.domain.TerminationCondition;

/**
 * 게임의 시작, 재시작, 종료를 관리하는 클래스.
 */
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
        TerminationCondition terminationManager = new TerminationCondition(isRestart);
        return terminationManager.isRestart();
    }
}
