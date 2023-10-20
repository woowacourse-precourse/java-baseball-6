package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {

    private NumberGenerator numberGenerator;

    @BeforeEach
    void setUp() {
        numberGenerator = new NumberGenerator();
    }

    @Test
    void shouldGenerateThreeRandomNumbers() {
        List<Integer> numbers = numberGenerator.generateRandomNumbers();

        assertThat(numbers).hasSize(3);
    }

    @Test
    void generatedNumbersShouldNotContainDuplicates() {
        List<Integer> numbers = numberGenerator.generateRandomNumbers();

        assertThat(numbers).doesNotHaveDuplicates();
    }

    @Test
    void generatedNumbersShouldBeInRange() {
        List<Integer> numbers = numberGenerator.generateRandomNumbers();

        for (int number : numbers) {
            assertThat(number).isBetween(1, 9);
        }
    }
}
