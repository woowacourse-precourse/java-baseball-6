package baseball.service;

import baseball.domain.Computer;
import baseball.view.NextGameUserInputView;

public class GameStatusService {
    private static final int RESTART_GAME = 1;
    private static final int END_GAME = 2;
    private boolean exitGame;
    private NextGameUserInputView nextGameUserInputView = new NextGameUserInputView();

    public boolean isExitGame() {
        return exitGame;
    }

    public void processNextGameStatus(Computer computer) {
        setNextGameStatus(nextGameUserInputView.askNextGame(), computer);
    }

    public void setNextGameStatus(int askNextGameChoice, Computer computer) {
        if (askNextGameChoice == RESTART_GAME) {
            computer.setupGameNumbers();
        }
        if (askNextGameChoice == END_GAME) {
            exitGame = true;
        }
    }
}