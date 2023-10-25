package baseball.game.impl;

import baseball.game.BaseballGame;
import baseball.phase.Phase;
import baseball.phase.PhaseID;
import java.util.ArrayList;
import java.util.List;

public class BaseballGameImpl implements BaseballGame {
    private Phase currentPhase;
    private Phase[] phases = new Phase[PhaseID.values().length];
    private List<Integer> answer;

    public BaseballGameImpl(int numSize) {
        answer = new ArrayList<>(numSize);
        for (PhaseID phase : PhaseID.values()) {
            phases[phase.getId()] = phase.getPhase(this);
        }
    }

    @Override
    public void init() throws IllegalArgumentException {
        this.currentPhase = phases[PhaseID.INIT.getId()];
        while (true) {
            this.currentPhase.play();
            PhaseID nextPhase = this.currentPhase.nextPhase();
            if (nextPhase == null) {
                break;
            }
            this.currentPhase = this.phases[nextPhase.getId()];
        }
    }

    @Override
    public List<Integer> getAnswer() {
        return answer;
    }
}
