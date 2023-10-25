package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

    @Test
    void 목표_숫자_생성_테스트() {
        int goal = 3;
        int start = 1;
        int end = 9;
        List<Integer> numbers = NumberGenerator.makeNumbers(start, end, goal);
        assertThat(numbers.size()).isEqualTo(goal);
    }

    @Test
    void 생성된_숫자가_범위안의_수여야_한다() {
        int goal = 3;
        int start = 1;
        int end = 9;
        List<Integer> numbers = NumberGenerator.makeNumbers(start, end, goal);
        for (Integer number : numbers) {
            assertThat(number).isBetween(start, end);
        }
    }
}
