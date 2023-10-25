package baseball.phase.impl;

import baseball.game.BaseballGame;
import baseball.phase.Phase;
import baseball.phase.PhaseID;
import java.util.List;

public class InitPhase implements Phase {
    private BaseballGame baseballGame;

    public InitPhase() {
    }

    @Override
    public PhaseID nextPhase() {
        return PhaseID.GUESS;
    }

    @Override
    public void play() {
        List<Integer> answer = this.baseballGame.getAnswer();

    }

    @Override
    public void setGame(BaseballGame game) {
        this.baseballGame = game;
    }
}