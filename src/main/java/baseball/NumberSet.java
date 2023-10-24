package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberSet {
    private List<Integer> numbers;

    public NumberSet(Integer digit1, Integer digit2, Integer digit3) {
        List<Integer> numbers = Arrays.asList(digit1, digit2, digit3);
        boolean is1Digit = numbers.stream().allMatch(digit -> 1 <= digit && digit <= 9);
        if (!is1Digit)
            throw new IllegalArgumentException();
        this.numbers = numbers;
    }

    public NumberSet(Integer number) {
        this(
                number / 100,
                (number / 10) % 10,
                number % 10
        );
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean isUnique() {
        Set<Integer> set = new HashSet<>(this.numbers);
        return set.size() == this.numbers.size();
    }
}
