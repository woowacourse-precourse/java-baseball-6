package baseball.game.impl;

import baseball.evaluation.evaluator.Evaluator;
import baseball.evaluation.evaluator.impl.AnswerEvaluatorImpl;
import baseball.game.BaseballGame;
import baseball.phase.Phase;
import baseball.phase.PhaseID;

public class BaseballGameImpl implements BaseballGame {
    private Phase currentPhase;
    private Phase[] phases = new Phase[PhaseID.values().length];
    private Evaluator evaluator;

    public BaseballGameImpl(int numSize) {
        evaluator = new AnswerEvaluatorImpl(numSize);
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
    public Evaluator getEvaluator() {
        return this.evaluator;
    }
}
