package baseball.domain.ball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

final class BallNumberTest {

    @DisplayName("BallNumber가 1~9 범위의 수라면 정상 생성")
    @Test
    void test() {
        // given
        // when
        // then
        final BallNumber ballNumber = new BallNumber(1);
        final BallNumber ballNumber2 = new BallNumber(9);
        assertThat(ballNumber.number()).isEqualTo(1);
        assertThat(ballNumber2.number()).isEqualTo(9);
    }


    @DisplayName("BallNumber가 1~9 범위의 수가 아니라면 예외 발생")
    @Test
    void ballNumberLessThanOneOrGreaterThanNine() {
        // given
        // when
        // then
        assertThatThrownBy(
                () -> new BallNumber(0)
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("BallNumbers는 1~9 사이의 3자리 수여야 합니다.");

        assertThatThrownBy(
                () -> new BallNumber(10)
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("BallNumbers는 1~9 사이의 3자리 수여야 합니다.");
    }
}
