package baseball.model;

import baseball.view.ErrorConstants;

import java.util.List;


public class BaseballNumber {
    private static final int BASEBALL_NUMBER_SIZE = 3;

    private final List<Integer> numbers;

    private BaseballNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static BaseballNumber create(List<Integer> numbers) {
        validateDifferent(numbers);
        return new BaseballNumber(numbers);
    }

    private static void validateDifferent(List<Integer> numbers) {
        int count = (int) numbers.stream().distinct().count();
        if (count != BASEBALL_NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorConstants.NOT_DISTINCT_NUMBERS_ERROR);
        }
    }

}
