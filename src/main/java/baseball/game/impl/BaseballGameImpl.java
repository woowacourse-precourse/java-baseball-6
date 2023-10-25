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
        System.out.println("숫자 야구 게임을 시작합니다.");
        this.currentPhase = this.phases[PhaseID.GUESS.getId()];
    }

    @Override
    public void init() {
        for (PhaseID phase : PhaseID.values()) {
            phases[phase.getId()] = phase.getPhase(this);
        }
        evaluator.resetAnswer();
    }

    @Override
    public void display() {
        this.currentPhase.display();
    }

    @Override
    public void validateInput(String input) {
        this.currentPhase.validateInput(input);
    }

    @Override
    public void action(String input) {
        PhaseID nextPhase = this.currentPhase.action(input);
        this.currentPhase = this.phases[nextPhase.getId()];
    }

    @Override
    public boolean isOver() {
        return this.currentPhase == null;
    }

    @Override
    public Evaluator getEvaluator() {
        return this.evaluator;
    }
}
