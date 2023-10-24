package baseball.player;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.common.Constants.*;

public class Numbers {
    private List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumberRange(numbers);
        validateDuplicate(numbers);
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

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> setNumbers = new HashSet<>(numbers);
        if (setNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(NUMBERS_DUPLICATE_ERROR);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
