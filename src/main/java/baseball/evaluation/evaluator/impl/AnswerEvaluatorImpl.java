package baseball.evaluation.evaluator.impl;

import baseball.evaluation.evaluator.Evaluator;
import baseball.evaluation.result.EvalResult;
import baseball.evaluation.result.impl.BallStrike;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class AnswerEvaluatorImpl implements Evaluator {
    private List<Integer> answer;
    private final int boardSize;

    public AnswerEvaluatorImpl(int numSize) {
        this.boardSize = numSize;
        this.answer = new ArrayList<>();
        resetAnswer();
    }

    @Override
    public EvalResult evaluate(List<Integer> guess) {
        int guessSize = guess.size();
        int strikes = 0;
        int balls = 0;
        for (int guessPos = 0; guessPos < guessSize; guessPos++) {
            int ansPos = this.answer.indexOf(guess.get(guessPos));
            if (guessPos == ansPos) {
                strikes += 1;
            } else if (ansPos != -1) {
                balls += 1;
            }
        }
        return new BallStrike(balls, strikes);
    }

    @Override
    public void resetAnswer() {
        int insertedNumber = 0;
        this.answer.clear();
        while (insertedNumber < this.boardSize) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!this.answer.contains(randomNumber)) {
                this.answer.add(randomNumber);
                insertedNumber += 1;
            }
        }
    }
}
