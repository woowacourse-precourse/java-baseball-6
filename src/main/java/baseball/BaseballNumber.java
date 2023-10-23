package baseball;

import java.util.HashSet;
import java.util.Set;

public class BaseballNumber {
    private final int[] numbers;

    BaseballNumber(int[] numbers) {
        this.numbers = numbers;
        checkNumbers();
    }

    private void checkNumbers() {
        assert (numbers.length == 3);
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            assert (0 < number && number < 10);
            set.add(number);
        }
        assert (set.size() == 3);
    }
}
