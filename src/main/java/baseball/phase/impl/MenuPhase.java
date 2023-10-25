package baseball.phase.impl;

import baseball.game.BaseballGame;
import baseball.phase.Phase;
import baseball.phase.PhaseID;

public class MenuPhase implements Phase {
    private BaseballGame baseballGame;

    public MenuPhase() {
    }


    @Override
    public void display() {

    }

    @Override
    public void validateInput(String input) {

    }

    @Override
    public PhaseID action(String input) {
        return null;
    }

    @Override
    public void setGame(BaseballGame game) {
        this.baseballGame = game;
    }
}
