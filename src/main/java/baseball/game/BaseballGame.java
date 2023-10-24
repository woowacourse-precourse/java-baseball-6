package baseball.game;

import baseball.game.enums.BaseballGameMessage;
import baseball.io.Input;
import baseball.io.Output;

public class BaseballGame {

    private boolean wantNewGame = true;

    public void play() {
        announceGameStart();

        while (wantNewGame) {
            Turn turn = new Turn();
            turn.play();

            announceWin();
            askRestart();
        }
    }

    private void announceGameStart() {
        Output.consoleLine(BaseballGameMessage.GAME_START_MESSAGE.get());
    }

    private void announceWin() {
        Output.consoleLine(BaseballGameMessage.GAME_WIN_MESSAGE.get());
    }

    private void askRestart() {
        Output.consoleLine(BaseballGameMessage.GAME_RESTART_MESSAGE.get());
        BaseballGameRestarts restarts = BaseballGameRestarts.find(Input.consoleNumber());

        if (restarts.wantToFinish()) {
            wantNewGame = false;
        }
    }

}
