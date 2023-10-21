package baseball.domain;

import java.util.List;

public final class AnswerNumbers {

    private final Numbers numbers;

    public AnswerNumbers(final List<Integer> numbers) {
        this.numbers = new Numbers(numbers);
    }
}
