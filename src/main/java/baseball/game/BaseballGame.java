package baseball.game;

import baseball.evaluation.evaluator.Evaluator;

public interface BaseballGame {
    void init() throws IllegalArgumentException;

    Evaluator getEvaluator();
}
