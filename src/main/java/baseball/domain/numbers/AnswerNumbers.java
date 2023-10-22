package baseball.domain.numbers;

import java.util.List;

public final class AnswerNumbers {
    static final int NUMBER_SIZE = 3;

    private final List<Integer> answerNumbers;

    List<Integer> getAnswerNumbers() {
        return answerNumbers;
    }

    private AnswerNumbers(List<Integer> answerNumbers) {
        this.answerNumbers = answerNumbers;
    }

    public static AnswerNumbers createAnswerNumbers(NumberGenerator numberGenerator) {
        List<Integer> generateNumbers = numberGenerator.generate(NUMBER_SIZE);
        return new AnswerNumbers(generateNumbers);
    }

    public boolean isSameWithAnswer(List<Integer> numbers) {
        String answer = answerNumbers.toString();
        return answer.equals(numbers.toString());
    }

    public Integer findIndexOfSameNumber(int number) {
        for (int i = 0; i < answerNumbers.size(); i++) {
            if (answerNumbers.get(i) == number) {
                return i;
            }
        }
        return null;
    }
}
