package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BallNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 10})
    @DisplayName("야구 숫자가 1부터 9까지의 숫자가 아니라면 예외가 발생한다.")
    void validateSizeTest(final int number) {
        assertThatThrownBy(() -> new BallNumber(number, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("야구 숫자를 비교할 수 있다. - 낫싱")
    void testCompareWhenNoEqualNumber() {
        BallNumber computer = new BallNumber(1, 0);
        BallNumber player = new BallNumber(2, 0);
        assertThat(computer.compare(player))
                .isEqualTo(CompareResult.NOTHING);
    }

    @Test
    @DisplayName("야구 숫자를 비교할 수 있다. - 스트라이크")
    void testCompareWhenEqualNumberSamePosition() {
        // (1, 0)
        BallNumber computer = new BallNumber(1, 0);
        BallNumber player = new BallNumber(1, 0);
        assertThat(computer.compare(player))
                .isEqualTo(CompareResult.STRIKE);

        // (5, 2)
        computer = new BallNumber(5, 2);
        player = new BallNumber(5, 2);
        assertThat(computer.compare(player))
                .isEqualTo(CompareResult.STRIKE);
    }

    @Test
    @DisplayName("야구 숫자를 비교할 수 있다. - 볼")
    void testCompareWhenEqualNumberDifferentPosition() {
        // com(1, 0), player(1, 1)
        BallNumber computer = new BallNumber(1, 0);
        BallNumber player = new BallNumber(1, 1);
        assertThat(computer.compare(player))
                .isEqualTo(CompareResult.BALL);

        // com(2, 1), player(2, 0)
        computer = new BallNumber(2, 1);
        player = new BallNumber(2, 0);
        assertThat(computer.compare(player))
                .isEqualTo(CompareResult.BALL);

        // com(5, 2), player(5, 1)
        computer = new BallNumber(5, 1);
        player = new BallNumber(5, 2);
        assertThat(computer.compare(player))
                .isEqualTo(CompareResult.BALL);
    }
}
