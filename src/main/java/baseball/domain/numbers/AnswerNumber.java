package baseball.domain.numbers;

import java.util.List;

public final class AnswerNumber {
    private final BaseBallNumber answer;

    public AnswerNumber(BaseBallNumber answer) {
        this.answer = answer;
    }

    public static AnswerNumber createAnswerNumbers(NumberGenerator numberGenerator) {
        List<Integer> generateNumbers = numberGenerator.generate(BaseBallNumber.NUMBER_LENGTH);
        BaseBallNumber answer = new BaseBallNumber(generateNumbers);
        return new AnswerNumber(answer);
    }

    public boolean isSameWithAnswer(BaseBallNumber other) {
        String otherNumber = other.getNumber().toString();
        return answer.getNumber().toString().equals(otherNumber);
    }

    public boolean isSameNumberOfIndex(BaseBallNumber other, int index) {
        int targetNumber = other.getNumber().get(index);
        return answer.getNumber().get(index).equals(targetNumber);
    }

    public boolean hasContainNumberOfIndex(BaseBallNumber other, int index) {
        int targetNumber = other.getNumber().get(index);
        return answer.getNumber().contains(targetNumber);
    }
}