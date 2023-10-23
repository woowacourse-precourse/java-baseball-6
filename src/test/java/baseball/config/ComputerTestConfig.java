package baseball.config;

import baseball.domain.Computer;
import baseball.utils.NumberGenerator;
import java.util.List;

public class ComputerTestConfig {
    public static class TestNumberGenerator implements NumberGenerator {
        private final List<Integer> numbers;

        public TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public List<Integer> generate() {
            return numbers;
        }
    }

    public static class TestComputer extends Computer {
        public TestComputer(List<Integer> numbers) {
            super(new TestNumberGenerator(numbers));
        }
    }
}
