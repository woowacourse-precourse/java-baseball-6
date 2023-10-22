package baseball.domain;

import java.util.List;

public class Numbers {
    private static final int ZERO_COUNT = 0;
    private static final int ONE_COUNT = 1;
    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    protected Score calculateScore(String input) {
        int ball = ZERO_COUNT;
        int strike = ZERO_COUNT;
        for (int i = 0; i < numbers.size(); i++) {
            int answerNumber = numbers.get(i);
            int inputNumber = Character.getNumericValue(input.charAt(i));
            ball += countBall(numbers, answerNumber, inputNumber);
            strike += countStrike(answerNumber, inputNumber);
        }
        return new Score(new Ball(ball), new Strike(strike));
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
