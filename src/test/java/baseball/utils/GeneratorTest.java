package baseball.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

class GeneratorTest {

    @Test
    void generateTest() {
        int size = 3;
        int startRange = 1;
        int endRange = 9;

        List<Integer> numbers = Generator.makeNumbers(size, startRange, endRange);

        assertThat(numbers.size()).isEqualTo(3);
    }
}