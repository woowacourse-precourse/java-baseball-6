package baseball.domain;

import baseball.util.RandomNumberGenerator;

import java.util.List;

public class AnswerNumbers {

    public static final int SIZE = 3;

    private final List<Integer> answerNumbers;

    private AnswerNumbers(List<Integer> targetNumbers) {
        this.answerNumbers = targetNumbers;
    }

    public static AnswerNumbers generate() {
        List<Integer> randomNumbers = RandomNumberGenerator.pickNumbersInRangeWithoutDuplication(1, 9);
        return new AnswerNumbers(randomNumbers);
    }

    public boolean isStrike(final int position, final int number) {
        return answerNumbers.get(position).equals(number);
    }

    public boolean isBall(final int position, final int number) {
        if (answerNumbers.contains(number)) {
            return !isStrike(position, number);
        }

        return false;
    }

    public void calculateScore(PlayerNumbers playerNumbers) {

        for (int position = 0; position < AnswerNumbers.SIZE; position++) {

            int playerNumberByPosition = playerNumbers.getNumberByPosition(position);

            if (isStrike(position, playerNumberByPosition)) {
                Score.STRIKE.addCount();
                continue;
            }

            if (isBall(position, playerNumberByPosition)) {
                Score.BALL.addCount();
            }
        }
    }
}
