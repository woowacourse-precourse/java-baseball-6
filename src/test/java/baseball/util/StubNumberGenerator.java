package baseball.util;

import java.util.Arrays;
import java.util.List;

public class StubNumberGenerator implements NumberGenerator {

    private final String numbers;

    public StubNumberGenerator(final String numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> generate() {
        return Arrays.stream(numbers.split(""))
                .map(Integer::parseInt)
                .toList();
    }
}
