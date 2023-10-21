package model.system;

import model.referee.GameScoreboard;

public class GameTerminator {

    public GameTerminator() {
    }

    public boolean isGameStillRunning(GameScoreboard gameScoreboard) {
        return !gameScoreboard.isThreeStrike();
    }

}
