package baseball.model;

import static baseball.utils.Constant.NUMBER_LENGTH;

import java.util.List;

public class CountStrikeAndBall {
    public final int strike;
    public final int ball;

    public CountStrikeAndBall(List<Integer> answerNumbers, List<Integer> userNumbers) {
        strike = countStrike(answerNumbers, userNumbers);
        ball = countBall(answerNumbers, userNumbers);
    }

    private int countStrike(List<Integer> answerNumbers, List<Integer> userNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (answerNumbers.get(i) == userNumbers.get(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int countBall(List<Integer> answerNumbers, List<Integer> userNumbers) {
        int ballCount = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (answerNumbers.get(i) != userNumbers.get(i) && answerNumbers.contains(userNumbers.get(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }
}
