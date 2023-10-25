package baseball.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class StrikeCounterTest {
    final Counter strikeCounter =  new StrikeCounter();

    @Test
    void 스트라이크가_없다() {
        assertThat(strikeCounter.count(List.of(1, 2, 3), List.of(7, 8, 9)))
                .isEqualTo(0);
    }

}