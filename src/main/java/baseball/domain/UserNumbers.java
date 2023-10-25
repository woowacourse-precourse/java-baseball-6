package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public final class UserNumbers {
    private static final int NUMBERS_SIZE = 3;
    private final List<Integer> numbers;

    public UserNumbers(List<Integer> numbers) {
        this.numbers = numbers;
        validate();
    }

    private void validateSize() {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumber(List<Integer> compare, int number) {
        if (compare.contains(number)) {
            throw new IllegalArgumentException();
        }
    }

    private void validate() {
        validateSize();
        List<Integer> compare = new ArrayList<>();
        for (Integer number : numbers) {
            validateNumber(compare, number);
            compare.add(number);
        }
    }


    public int get(int i) {
        return numbers.get(i);
    }
}
