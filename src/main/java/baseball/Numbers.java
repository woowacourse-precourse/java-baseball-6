package baseball;

import java.util.List;

import static baseball.Constants.*;

public class Numbers {
    private List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(NUMBERS_SIZE_ERROR);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        numbers.stream()
                .forEach(number -> {
                    if (number < NUMBER_MIN_RANGE || number > NUMBER_MAX_RANGE) {
                        throw new IllegalArgumentException(NUMBER_RANGE_ERROR);
                    }
                });
    }
}
