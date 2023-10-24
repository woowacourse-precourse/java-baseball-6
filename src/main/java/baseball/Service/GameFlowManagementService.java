package baseball.Service;

import baseball.Domain.Computer;
import baseball.View.GamePlayerInputView;

public class GameFlowManagementService {
    private static final int GAME_RESTART = 1;
    private static final int GAME_FINISH = 2;
    private boolean gameQuit;
    private GamePlayerInputView GamePlayerInputView = new GamePlayerInputView();

    public boolean gameQuit() {
        return gameQuit;
    }

    public void nextGameFlow(Computer computer) { //이 메서드 내에서 selectGameRestart 변수 전달할 수 있도록 리팩토링
        int selectGameRestart = GamePlayerInputView.nextGameSetup();
        nextGameSetup(selectGameRestart, computer);
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
