package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.domain.NumberGenerator;
import baseball.domain.RandomNumberGenerator;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest extends NsTest {

    @Test
    void init은_pickedNumbers를_초기화한다() {
        NumberGenerator randomNumberGenerator = RandomNumberGenerator.init();
        assertThat(randomNumberGenerator.getPickedNumbers()).isEmpty();
    }

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
        NumberGenerator randomNumberGenerator = RandomNumberGenerator.init();
        System.out.println(randomNumberGenerator.generate());
    }

    @Test
    void 랜덤_숫자가_중복없이_잘_뽑히는지_테스트() {
        NumberGenerator numberGenerator = RandomNumberGenerator.init();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            int randomNumber = numberGenerator.generate();
            assertTrue(set.add(randomNumber));
        }
    }

    @Test
    void 최대9번_뽑았을때_1_9사이의_숫자로_나오는지_확인() {
        NumberGenerator generator = RandomNumberGenerator.init();
        for (int i = 0; i < 9; i++) {
            int number = generator.generate();
            assertThat(number).isBetween(1, 9);
        }
    }
}
