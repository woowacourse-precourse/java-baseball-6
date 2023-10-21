package baseball;

import java.util.List;

public class Answer {
    public static final int ZERO_COUNT = 0;
    public static final int ONE_COUNT = 1;
    private final List<Integer> answer;

    public Answer(List<Integer> answer) {
        this.answer = answer;
    }

    public Score match(String input) {
        int ball = ZERO_COUNT;
        int strike = ZERO_COUNT;
        for (int i = 0; i < answer.size(); i++) {
            int answerNumber = answer.get(i);
            int inputNumber = Character.getNumericValue(input.charAt(i));
            ball += countBall(answer, answerNumber, inputNumber);
            strike += countStrike(answerNumber, inputNumber);
        }
        return new Score(ball, strike);
    }

    private int countBall(List<Integer> answer, Integer answerNumber, int inputNumber) {
        if (answerNumber != inputNumber && answer.contains(inputNumber)) {
            return ONE_COUNT;
        }
        return ZERO_COUNT;
    }

    private int countStrike(Integer answerNumber, int inputNumber) {
        if (answerNumber == inputNumber) {
            return ONE_COUNT;
        }
        return ZERO_COUNT;
    }
}
