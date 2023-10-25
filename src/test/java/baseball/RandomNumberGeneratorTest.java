package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.util.RandomNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {
    @Test
    void 생성된_무작위_숫자가_3자리인지_테스트() {
        List<Integer> numbers = RandomNumberGenerator.generate();
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    void 생성된_무작위_숫자가_중복이_없는지_테스트() {
        for (int i = 0; i < 100; i++) {
            List<Integer> numbers = RandomNumberGenerator.generate();
            assertThat(numbers).doesNotHaveDuplicates();
        }
    }
}