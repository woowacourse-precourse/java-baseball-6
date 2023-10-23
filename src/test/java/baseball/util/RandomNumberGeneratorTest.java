package baseball.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {

    private RandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    public void setUp() {
        randomNumberGenerator = new RandomNumberGenerator();
    }

    @Test
    void testGenerateReturnsValidRandomNumbers() {
        // when
        List<Integer> result = randomNumberGenerator.generate();

        // then
        assertThat(result).hasSize(3)
                .allSatisfy(number -> assertThat(number).isBetween(1, 9));
    }
}
