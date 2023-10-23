package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class RandomNumberGeneratorTest {

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
