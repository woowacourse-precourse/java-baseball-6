package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public record GameNumber(List<Integer> numbers) {
    public GameNumber {
        validate(numbers);
    }

    private void validateSize() {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumber(List<Integer> compare, int number) {
        if (compare.contains(number)) {
            throw new IllegalArgumentException();
        }
    }

    private void validate(List<Integer> numbers) {
        validateSize();
        List<Integer> compare = new ArrayList<>();
        for (Integer number : numbers) {
            validateNumber(compare, number);
            compare.add(number);
        }
    }

}
