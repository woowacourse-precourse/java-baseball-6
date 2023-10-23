package baseball.computer.generator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomNumberGeneratorTest {
    private static RandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    void setUp() {
        randomNumberGenerator = new RandomNumberGenerator();
    }

    @Test
    void generate_random_number() {
        int randomNumber = randomNumberGenerator.generateRandomNumber();

        assertThat(randomNumber).isBetween(1, 9);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void number_exists_in_generated_numbers(int index) {
        Integer number = randomNumberGenerator.getNumbers().get(index);

        assertThat(randomNumberGenerator.isNumberExisted(number)).isTrue();
    }

    @Test
    void not_modified_numbers(){
        List<Integer> numbers = randomNumberGenerator.getNumbers();
        numbers.add(4);

        assertThat(randomNumberGenerator.getNumbers().size()).isEqualTo(3);
    }
}
