package baseball.phase.impl;

import baseball.game.BaseballGame;
import baseball.phase.Phase;
import baseball.phase.PhaseID;

public class MenuPhase implements Phase {
    private BaseballGame baseballGame;

    public MenuPhase() {
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
