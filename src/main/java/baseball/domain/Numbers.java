package baseball.domain;

import baseball.validation.NumbersValidator;

import java.util.List;

public class Numbers {

    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 9;
    public static final int SIZE = 3;

    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        validateNumbers();
        this.numbers = numbers;
    }

    private void validateNumbers() {
        NumbersValidator.validateNumbersSize(SIZE, numbers);
        NumbersValidator.validateDuplicateNumbers(numbers);
        NumbersValidator.validateContainsZero(numbers);
    }
}
