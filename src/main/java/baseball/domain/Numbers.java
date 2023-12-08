package baseball.domain;

import baseball.validator.NumbersValidator;

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

    public int calculateStrikes(Numbers compareNumbers) {
        List<Integer> numbers = compareNumbers.numbers;
        int strikesCount = 0;
        for (int i = 0; i < SIZE; i++) {
            Integer number = numbers.get(i);
            if (this.numbers.indexOf(number) == i) {
                strikesCount++;
            }
        }
        return strikesCount;
    }

    public int calculateBalls(Numbers compareNumbers) {
        List<Integer> numbers = compareNumbers.numbers;
        int ballsCount = 0;
        for (int i = 0; i < SIZE; i++) {
            Integer number = numbers.get(i);
            if (this.numbers.contains(number) && this.numbers.indexOf(number) != i) {
                ballsCount++;
            }
        }
        return ballsCount;
    }
}
