package baseball.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class StrikeCounterTest {
    final Counter strikeCounter = new StrikeCounter();

    @Test
    void 스트라이크가_없다() {
        assertThat(strikeCounter.count(List.of(1, 2, 3), List.of(7, 8, 9)))
                .isEqualTo(0);
    }

    @Test
    void 스트라이크가_1개_존재한다() {
        assertThat(strikeCounter.count(List.of(1, 2, 3), List.of(1, 8, 9)))
                .isEqualTo(1);
    }

    @Test
    void 스트라이크가_2개_존재한다() {
        assertThat(strikeCounter.count(List.of(1, 2, 3), List.of(1, 2, 9)))
                .isEqualTo(2);
    }

    @Test
    void 스트라이크가_3개_존재한다() {
        assertThat(strikeCounter.count(List.of(1, 2, 3), List.of(1, 2, 3)))
                .isEqualTo(3);
    }
}