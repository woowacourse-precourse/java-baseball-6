package baseball.helper;

import baseball.util.NumberGenerator;
import java.util.List;

public class TestNumberGenerator implements NumberGenerator {

    private final List<Integer> numbers;

    public TestNumberGenerator(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> generateNumbers() {
        return numbers;
    }
}
