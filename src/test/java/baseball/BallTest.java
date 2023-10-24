package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallTest {

    @Test
    @DisplayName("같은 숫자가 존재하지 않으면 낫싱이다.")
    void doesNotExistsSameNumber_Then_Nothing() {
        Ball computer = Ball.of(1, 0);
        Ball player = Ball.of(2, 0);
        assertThat(computer.compare(player))
                .isEqualTo(CompareResult.NOTHING);
    }

    @Test
    @DisplayName("같은 숫자가 같은 자리에 존재하면 스트라이크이다.")
    void existsSameNumberInSamePosition_Then_Strike() {
        // (1, 0)
        Ball computer = Ball.of(1, 0);
        Ball player = Ball.of(1, 0);
        assertThat(computer.compare(player))
                .isEqualTo(CompareResult.STRIKE);

        // (5, 2)
        computer = Ball.of(5, 2);
        player = Ball.of(5, 2);
        assertThat(computer.compare(player))
                .isEqualTo(CompareResult.STRIKE);
    }

    @Test
    @DisplayName("같은 숫자가 다른 자리에 존재하면 볼이다.")
    void existsSameNumberInDifferentPosition_Then_Ball() {
        // com(1, 0), player(1, 1)
        Ball computer = Ball.of(1, 0);
        Ball player = Ball.of(1, 1);
        assertThat(computer.compare(player))
                .isEqualTo(CompareResult.BALL);

        // com(2, 1), player(2, 0)
        computer = Ball.of(2, 1);
        player = Ball.of(2, 0);
        assertThat(computer.compare(player))
                .isEqualTo(CompareResult.BALL);

        // com(5, 2), player(5, 1)
        computer = Ball.of(5, 1);
        player = Ball.of(5, 2);
        assertThat(computer.compare(player))
                .isEqualTo(CompareResult.BALL);
    }
}
