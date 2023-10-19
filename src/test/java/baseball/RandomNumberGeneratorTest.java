package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest extends NsTest {

    @Test
    void randomNumberTest() {
        assertRandomNumberInRangeTest(
            () -> {
                run();
                assertThat(output()).contains("1");
            }, 1
        );
    }

    @Override
    protected void runMain() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        System.out.println(randomNumberGenerator.generate());
    }
}
