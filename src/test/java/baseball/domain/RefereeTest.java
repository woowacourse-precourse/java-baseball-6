package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {

    @DisplayName("1볼")
    @Test
    void ball() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> player = List.of(3, 4, 5);
        assertThat(new Referee().countBallAndStrike(computer, player))
                .isEqualTo(List.of(1, 0));
    }

    @DisplayName("2스트라이크")
    @Test
    void strike() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> player = List.of(9, 2, 3);
        assertThat(new Referee().countBallAndStrike(computer, player))
                .isEqualTo(List.of(0, 2));
    }

    @DisplayName("2볼 1스트라이크")
    @Test
    void ballAndStrike() {
        List<Integer> computer = List.of(5, 2, 8);
        List<Integer> player = List.of(8, 2, 5);
        assertThat(new Referee().countBallAndStrike(computer, player))
                .isEqualTo(List.of(2, 1));
    }

    @DisplayName("낫싱")
    @Test
    void nothing() {
        List<Integer> computer = List.of(5, 2, 8);
        List<Integer> player = List.of(4, 1, 7);
        assertThat(new Referee().countBallAndStrike(computer, player))
                .isEqualTo(List.of(0, 0));
    }
}