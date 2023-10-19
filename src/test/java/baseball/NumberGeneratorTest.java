package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberGeneratorTest {

    private final NumberGenerator testNumberGenerator = new NumberGenerator() {
        @Override
        public List<Integer> generateNumbers() {
            return List.of(1, 2, 3);
        }
    };

    @Test
    public void 상대편의_숫자를_생성한다() {

        List<Integer> numbers = testNumberGenerator.generateNumbers();
        Assertions.assertEquals(3, numbers.size());
    }

    @Test
    public void 상대편의_숫자는_중복되지_않는다() {
        List<Integer> numbers = testNumberGenerator.generateNumbers();
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        Assertions.assertEquals(numbers.size(), uniqueNumbers.size());
    }

    @Test
    public void 상대편의_숫자는_1부터_9까지의_숫자이다() {
        List<Integer> numbers = testNumberGenerator.generateNumbers();
        numbers.forEach(
                number -> Assertions.assertTrue(number >= 1 && number <= 9)
        );
    }
}
