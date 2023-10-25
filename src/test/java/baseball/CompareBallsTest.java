package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CompareBallsTest {

    @Test
    @DisplayName("같은 숫자 개수 확인")
    void countTotal() {
        // given
        CompareBalls compareBalls = new CompareBalls();

        // when

        // then
        assertThat(3).isEqualTo(compareBalls.countTotal(Arrays.asList(1,2,3), Arrays.asList(3,1,2)));
    }

    @Test
    @DisplayName("스트라이크 개수 확인")
    void countStrike() {
        // given
        CompareBalls compareBalls = new CompareBalls();

        // when

        // then
        assertThat(1).isEqualTo(compareBalls.countStrike(Arrays.asList(3,2,4),Arrays.asList(3,1,2)));
    }
}