package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.NumberGenerator;
import baseball.domain.RandomNumberGenerator;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    @Test
    void 랜덤_숫자가_중복없이_잘_뽑히는지_테스트() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.add(numberGenerator.generate());
        }
        assertThat(new HashSet<>(list).size() == list.size()).isTrue();
        System.out.println(list);
    }
}
