package baseball.Service;

import baseball.Domain.Computer;
import baseball.View.NextGamePlayerInputView;

public class GameFlowManagementService {
    private static final int GAME_RESTART = 1;
    private static final int GAME_FINISH = 2;
    private boolean gameQuit;
    private NextGamePlayerInputView nextGamePlayerInputView = new NextGamePlayerInputView();

    public boolean gameQuit() {
        return gameQuit;
    }

    public void nextGameFlow(Computer computer) {
        nextGameSetup(nextGamePlayerInputView.nextGameSetup(), computer);
    }

    public void nextGameSetup(int selectGameRestart, Computer computer) {
        if (selectGameRestart == GAME_RESTART) {
            computer.setComputerNumbers();
        }
        if (selectGameRestart == GAME_FINISH) {
            gameQuit = true;
        }
    }
}
