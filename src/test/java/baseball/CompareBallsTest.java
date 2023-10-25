package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CompareBallsTest {

    CompareBalls compareBalls = new CompareBalls();

    static List<Integer> computer;
    static List<Integer> player;

    @BeforeEach
    void beforeEach() {
        computer = Arrays.asList(1, 2, 3);
        player = Arrays.asList(3, 2, 1);
    }

    @Test
    @DisplayName("같은 숫자 개수 확인")
    void countTotal() {
        // given

        // when
        int total = compareBalls.countTotal(computer, player);

        // then
        assertThat(3).isEqualTo(total);
    }

    @Test
    @DisplayName("스트라이크 개수 확인")
    void countStrike() {
        // given

        // when
        int expectStrike = compareBalls.countStrike(computer, player);

        // then
        assertThat(1).isEqualTo(expectStrike);
    }
}