package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.Number;
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
        List<Number> result = randomNumberGenerator.generate();

        // then
        assertThat(result).hasSize(3);
    }
}
