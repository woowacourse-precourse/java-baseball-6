package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.util.CompareNumber;
import java.util.List;
import org.junit.jupiter.api.Test;

class CompareNumberTest {
    @Test
    void 스트라이크_개수_판별_테스트() {
        assertThat(CompareNumber.countStrike(List.of(1, 2, 3), List.of(1, 2, 3))).isEqualTo(3);
        assertThat(CompareNumber.countStrike(List.of(1, 2, 3), List.of(1, 2, 4))).isEqualTo(2);
        assertThat(CompareNumber.countStrike(List.of(1, 2, 3), List.of(1, 4, 5))).isEqualTo(1);
        assertThat(CompareNumber.countStrike(List.of(1, 2, 3), List.of(4, 5, 6))).isEqualTo(0);
    }

    @Test
    void 볼_개수_판별_테스트() {
        assertThat(CompareNumber.countBall(List.of(1, 2, 3), List.of(1, 2, 3))).isEqualTo(0);
        assertThat(CompareNumber.countBall(List.of(1, 2, 3), List.of(4, 5, 6))).isEqualTo(0);
        assertThat(CompareNumber.countBall(List.of(1, 2, 3), List.of(1, 3, 4))).isEqualTo(1);
        assertThat(CompareNumber.countBall(List.of(1, 2, 3), List.of(3, 2, 5))).isEqualTo(1);
        assertThat(CompareNumber.countBall(List.of(1, 2, 3), List.of(5, 3, 4))).isEqualTo(1);
        assertThat(CompareNumber.countBall(List.of(1, 2, 3), List.of(2, 1, 4))).isEqualTo(2);
        assertThat(CompareNumber.countBall(List.of(1, 2, 3), List.of(1, 3, 2))).isEqualTo(2);
        assertThat(CompareNumber.countBall(List.of(1, 2, 3), List.of(3, 1, 2))).isEqualTo(3);
    }
}