package baseball.domain.numbers;

import java.util.List;

public final class AnswerBaseBallNumber extends BaseBallNumber {
    private AnswerBaseBallNumber(List<Integer> answerNumbers) {
        super(answerNumbers);
    }

    public static AnswerBaseBallNumber createAnswerNumbers(NumberGenerator numberGenerator) {
        List<Integer> generateNumbers = numberGenerator.generate(NUMBER_LENGTH);
        return new AnswerBaseBallNumber(generateNumbers);
    }

    public boolean isSameWithAnswer(BaseBallNumber other) {
        String answer = this.number.toString();
        String otherNumber = other.number.toString();
        return answer.equals(otherNumber);
    }

    public boolean isSameNumberOfIndex(BaseBallNumber other, int index) {
        int targetNumber = other.number.get(index);
        return number.get(index).equals(targetNumber);
    }

    public boolean hasContainNumberOfIndex(BaseBallNumber other, int index) {
        int targetNumber = other.number.get(index);
        return this.number.contains(targetNumber);
    }
}