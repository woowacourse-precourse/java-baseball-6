package baseball.utilTest;

import baseball.util.RandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {
    @Test
    public void testMakeRandomNumber(){
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        String result = randomNumberGenerator.makeRandomNumber();

        Assertions.assertThat(result.length()).isEqualTo(3);
    }
}
