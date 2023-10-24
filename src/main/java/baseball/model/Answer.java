package baseball.model;

import java.util.List;
import java.util.Objects;

public class Answer {
    private static final int INIT_VAL = 0;
    private static final int FIRST_IDX = 0;
    private static final int END_PLUS_ONE_IDX = 3;

    private final List<Integer> answer;

    public Answer(List<Integer> answer) {
        this.answer = answer;
    }

    // 검증 로직

    public GameScore calcScore(List<Integer> input) {
        GameScore score = new GameScore(INIT_VAL, INIT_VAL);
        for (int answerIdx = FIRST_IDX; answerIdx < END_PLUS_ONE_IDX; answerIdx++) {
            preCompare(input, score, answerIdx);
        }

        return score;
    }

    private void preCompare(List<Integer> input, GameScore score, int answerIdx) {
        for (int inputIdx = FIRST_IDX; inputIdx < END_PLUS_ONE_IDX; inputIdx++) {
            compareNumber(input, score, answerIdx, inputIdx);
        }
    }

    private void compareNumber(List<Integer> input, GameScore score, int answerIdx, int inputIdx) {
        if (Objects.equals(answer.get(answerIdx), input.get(inputIdx)) && answerIdx == inputIdx) {
            score.updateStrike();
        }

        if (Objects.equals(answer.get(answerIdx), input.get(inputIdx)) && answerIdx != inputIdx) {
            score.updateBall();
        }
    }
}
