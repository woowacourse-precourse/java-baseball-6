package baseball;

import java.util.List;
import java.util.Objects;

public class Answer {

    private final List<Integer> answer;

    public Answer(List<Integer> answer) {
        this.answer = answer;
    }

    // 검증 로직

    public GameScore calcScore(List<Integer> input) {
        GameScore score = new GameScore(0, 0);
        for (int answerIdx = 0; answerIdx < 3; answerIdx++) {
            preCompare(input, score, answerIdx);
        }

        return score;
    }

    private void preCompare(List<Integer> input, GameScore score, int answerIdx) {
        for (int inputIdx = 0; inputIdx < 3; inputIdx++) {
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
