package baseball.domain;

import java.util.List;

public final class AnswerNumbers {

    private static final int NUMBER_LIST_SIZE = 3;
    private final List<Number> answerNumbers;

    public AnswerNumbers(final List<Integer> randomNumbers) {
        validate(randomNumbers);
        this.answerNumbers = randomNumbers.stream().map(Number::new).toList();
    }

    private void validate(final List<Integer> randomNumbers) {
        if (isProperSize(randomNumbers)) {
            throw new IllegalStateException();
        }
    }

    private boolean isProperSize(final List<Integer> randomNumbers) {
        return randomNumbers.size() != NUMBER_LIST_SIZE;
    }
}
