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
    void isNumberOutOfBound_Then_ExceptionOccurs(final int number) {
        assertThatThrownBy(() -> new BallNumber(number, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("같은 숫자가 존재하지 않으면 낫싱이다.")
    void doesNotExistsSameNumber_Then_Nothing() {
        BallNumber computer = new BallNumber(1, 0);
        BallNumber player = new BallNumber(2, 0);
        assertThat(computer.compare(player))
                .isEqualTo(CompareResult.NOTHING);
    }

    @Test
    @DisplayName("같은 숫자가 같은 자리에 존재하면 스트라이크이다.")
    void existsSameNumberInSamePosition_Then_Strike() {
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
    @DisplayName("같은 숫자가 다른 자리에 존재하면 볼이다.")
    void existsSameNumberInDifferentPosition_Then_Ball() {
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
