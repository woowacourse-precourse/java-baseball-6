package baseball;

import baseball.model.CompareNumbers;
import baseball.validator.CompareValidator;
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

    @Test
    @DisplayName("숫자 비교 볼 개수 테스트")
    void 볼_개수_비교_검증테스트() {
        CompareValidator compareValidator = new CompareValidator();
        final List<Integer> computerNumbers = List.of(1, 3, 5);
        final List<Integer> playerNumbers = List.of(4, 6, 1);

        int[] resultBall = compareValidator.getNumberCompare(computerNumbers, playerNumbers);
        assertThat(resultBall[0]).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 비교 스트라이크 개수 테스트")
    void 스트라이크_개수_비교_검증테스트() {
        CompareValidator compareValidator = new CompareValidator();
        final List<Integer> computerNumbers = List.of(1, 3, 5);
        final List<Integer> playerNumbers = List.of(1, 4, 5);

        int[] resultStrike = compareValidator.getNumberCompare(computerNumbers, playerNumbers);
        assertThat(resultStrike[1]).isEqualTo(2);

    }

    @Test
    @DisplayName("숫자 비교 볼, 스트라이크 개수 테스트")
    void 볼_스트라이크_개수_비교_검증테스트() {
        CompareValidator compareValidator = new CompareValidator();
        final List<Integer> computerNumbers = List.of(1, 3, 5);
        final List<Integer> playerNumbers = List.of(4, 1, 5);

        int[] resultCount = compareValidator.getNumberCompare(computerNumbers, playerNumbers);
        assertThat(resultCount[0]).isEqualTo(1);
        assertThat(resultCount[1]).isEqualTo(1);
    }
}
