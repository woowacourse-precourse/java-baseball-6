package baseball;

import java.util.ArrayList;
import java.util.List;

public record GameNumber(List<Integer> numbers) {
    public GameNumber {
        validate(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException();
        }
        List<Integer> compare = new ArrayList<>();
        for (Integer number : numbers) {
            if (compare.contains(number)) {
                throw new IllegalArgumentException();
            }
            compare.add(number);
        }
    }
}
