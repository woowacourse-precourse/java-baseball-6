package baseball.game;

import baseball.evaluation.evaluator.Evaluator;

public interface BaseballGame {
    void init();

    void display();

    void validateInput(String input);

    void action(String input);

    boolean isOver();

    Evaluator getEvaluator();
}
