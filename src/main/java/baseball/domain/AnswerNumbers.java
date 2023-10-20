package baseball.domain;

import java.util.List;

public final class AnswerNumbers {
    static final int NUMBER_SIZE = 3;

    private final List<Integer> answerNumbers;

    public List<Integer> getAnswerNumbers() {
        return answerNumbers;
    }

    private AnswerNumbers(List<Integer> answerNumbers) {
        this.answerNumbers = answerNumbers;
    }

    public static AnswerNumbers createAnswerNumbers(AnswerNumberGenerator numberGenerator) {
        List<Integer> generateNumbers = numberGenerator.generate(NUMBER_SIZE);
        return new AnswerNumbers(generateNumbers);
    }
}
