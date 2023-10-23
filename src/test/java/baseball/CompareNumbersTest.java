package baseball;

import baseball.model.CompareNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CompareNumbersTest {
    @Test
    @DisplayName("스트라이크 개수 테스트")
    void 스트라이크_개수_비교_테스트() {
        final List<Integer> computerNumbers = List.of(1, 2, 3);
        final List<Integer> playerNumbers = List.of(3, 2, 1);

        assertThat(new CompareNumbers().strikeCount(computerNumbers, playerNumbers)).isEqualTo(1);
    }

    @Test
    @DisplayName("스트라이크 개수 테스트2")
    void 스트라이크_개수_비교_테스트2() {
        final List<Integer> computerNumbers = List.of(7, 8, 9);
        final List<Integer> playerNumbers = List.of(7, 6, 9);

        assertThat(new CompareNumbers().strikeCount(computerNumbers, playerNumbers)).isEqualTo(2);
    }

    @Test
    @DisplayName("볼 개수 테스트")
    void 볼_개수_비교_테스트() {
        final List<Integer> computerNumbers = List.of(4, 5, 6);
        final List<Integer> playerNumbers = List.of(6, 4, 3);

        assertThat(new CompareNumbers().ballCount(computerNumbers, playerNumbers)).isEqualTo(2);
    }

    @Test
    @DisplayName("볼 개수 테스트2")
    void 볼_개수_비교_테스트2() {
        final List<Integer> computerNumbers = List.of(1, 3, 5);
        final List<Integer> playerNumbers = List.of(3, 5, 1);

        assertThat(new CompareNumbers().ballCount(computerNumbers, playerNumbers)).isEqualTo(3);
    }
}
