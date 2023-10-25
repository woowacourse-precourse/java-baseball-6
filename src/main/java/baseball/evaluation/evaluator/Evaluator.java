package baseball.evaluation.evaluator;

import baseball.evaluation.result.EvalResult;
import java.util.List;

public interface Evaluator {
    EvalResult evaluate(List<Integer> guess);

    void resetAnswer();
}
