package baseball;


import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

    RandomNumberGenerator numberGenerator = new BaseballRandomGenerator();

    @Test
    void randomNumberTest() {
        assertRandomNumberInRangeTest(
            () -> {
                assertThat(numberGenerator.generateNonRepeatingRandomDigitSequence(3)).isEqualTo("123");
            }, 1,2,3
        );
    }

}
