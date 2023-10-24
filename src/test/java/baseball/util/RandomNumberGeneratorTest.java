package baseball.util;

import baseball.domain.GameNumberSet;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class RandomNumberGeneratorTest {

    @Test
    void generateRandomNumberSizeTest() {
        List<Integer> generate = RandomNumberGenerator.generate();
        Assertions.assertThat(generate.size()).isEqualTo(GameNumberSet.NUMBER_LENGTH);
    }

    @Test
    void generateRandomNumberNotContainsZero() {
        List<Integer> generate = RandomNumberGenerator.generate();
        Assertions.assertThat(!generate.contains(0)).isTrue();
    }

    @Test
    void generateRandomNumberNotDuplicate() {
        List<Integer> generate = RandomNumberGenerator.generate();
        int size = generate.size();
        long count = generate.stream().distinct().count();
        Assertions.assertThat(size == count).isTrue();
    }
}