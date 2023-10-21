package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumbersTest {

    Numbers numbers = new Numbers(List.of(1, 2, 3));

    @DisplayName("숫자 두 개를 비교하여 숫자야구 결과를 생성한다.")
    @Test
    void createCompareResult() {
        // given
        Numbers inputNumbers1 = new Numbers(List.of(1, 2, 3));
        Numbers inputNumbers2 = new Numbers(List.of(3, 2, 1));
        Numbers inputNumbers3 = new Numbers(List.of(4, 5, 6));

        // when
        List<Integer> compareResults1 = numbers.createCompareResult(inputNumbers1);
        List<Integer> compareResults2 = numbers.createCompareResult(inputNumbers2);
        List<Integer> compareResults3 = numbers.createCompareResult(inputNumbers3);

        // then
        assertAll(
                // 3스트라이크
                () -> assertThat(compareResults1.get(0)).isEqualTo(3),
                () -> assertThat(compareResults1.get(1)).isEqualTo(0),

                // 1스트라이크 2볼
                () -> assertThat(compareResults2.get(0)).isEqualTo(1),
                () -> assertThat(compareResults2.get(1)).isEqualTo(2),

                // 낫싱
                () -> assertThat(compareResults3.get(0)).isEqualTo(0),
                () -> assertThat(compareResults3.get(1)).isEqualTo(0)
        );
    }
}