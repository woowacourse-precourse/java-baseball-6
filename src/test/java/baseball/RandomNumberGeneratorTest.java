package baseball;


import baseball.controller.RandomNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class RandomNumberGeneratorTest {
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    @Test
    void testGenerateRandomNumber() {
        List<Integer> generatedNumbers = randomNumberGenerator.GenerateRandomNumber();

        boolean isSizeThree =
        assertThat()
    }
}
