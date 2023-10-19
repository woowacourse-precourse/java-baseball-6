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
}
