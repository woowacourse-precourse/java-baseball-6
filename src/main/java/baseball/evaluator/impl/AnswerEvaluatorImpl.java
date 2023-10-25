package baseball.evaluator.impl;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class AnswerEvaluatorImpl {
    private List<Integer> answer;
    private final int boardSize;

    public AnswerEvaluatorImpl(int numSize) {
        this.boardSize = numSize;
        this.answer = new ArrayList<>();
        while (numSize != 0) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!this.answer.contains(randomNumber)) {
                this.answer.add(randomNumber);
                numSize -= 1;
            }
        }
    }
}
