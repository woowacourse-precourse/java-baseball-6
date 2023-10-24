package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BallsTest {

    private Balls comBalls;

    @BeforeEach
    void setUp() {
        List<Integer> numbers = List.of(1, 2, 3);
        comBalls = Balls.of(numbers);
    }

    @Test
    @DisplayName("숫자 값과 위치가 모두 같은 경우 - 스트라이크")
    void strike() {
        // given
        List<Integer> numbers = List.of(1, 2, 3);
        Balls userBalls = Balls.of(numbers);

        // when
        Ground result = comBalls.compute(userBalls);

        // then
        assertThat(result).isEqualTo(Ground.of(3, 0));
    }

    @Test
    @DisplayName("숫자 값은 같지만 위치가 다른 경우 - 볼")
    void ball() {
        // given
        List<Integer> numbers = List.of(3, 1, 2);
        Balls userBalls = Balls.of(numbers);

        // when
        Ground result = comBalls.compute(userBalls);

        // then
        assertThat(result).isEqualTo(Ground.of(0, 3));
    }

    @Test
    @DisplayName("숫자 값과 위치가 모두 다른 경우 - 낫싱")
    void nothing() {
        // given
        List<Integer> numbers = List.of(4, 5, 6);
        Balls userBalls = Balls.of(numbers);

        // when
        Ground result = comBalls.compute(userBalls);

        // then
        assertThat(result).isEqualTo(Ground.of(0, 0));
    }

}