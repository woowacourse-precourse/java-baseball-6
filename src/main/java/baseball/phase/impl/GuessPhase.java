package baseball.phase.impl;

import baseball.game.BaseballGame;
import baseball.phase.Phase;
import baseball.phase.PhaseID;

public class GuessPhase implements Phase {
    private BaseballGame baseballGame;

    public GuessPhase() {
    }

    @Override
    public PhaseID nextPhase() {
        return null;
    }

    @Override
    public void play() {

    }

    @Override
    public void setGame(BaseballGame game) {
        this.baseballGame = game;
    }
}
