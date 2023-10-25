package baseball.domain;

import static baseball.domain.ErrorCode.INVALID_BALL_SIZE;
import static baseball.domain.ErrorCode.NOT_OTHER_NUMBERS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BallsTest {

    private Balls balls;

    @BeforeEach
    void setUp() {
        balls = new Balls(List.of(4, 3, 7));
    }

    @Test
    void 숫자_사이즈_검증_실패() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4);

        // when
        // then
        assertThatThrownBy(() -> new Balls(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_BALL_SIZE.getMessage());
    }

    @Test
    void 숫자_사이즈_검증() {
        // given
        List<Integer> numbers = List.of(1, 2, 3);

        // when
        Balls result = new Balls(numbers);

        // then
        assertThat(result).isNotNull();
    }

    @Test
    void 서로다른_숫자_검증_실패() {
        // given
        List<Integer> numbers = List.of(1, 1, 7);

        // when
        // then
        assertThatThrownBy(() -> new Balls(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_OTHER_NUMBERS.getMessage());
    }

    @Test
    void 서로다른_숫자_검증() {
        // given
        List<Integer> numbers = List.of(7, 3, 6);

        // when
        Balls result = new Balls(numbers);

        // then
        assertThat(result).isNotNull();
    }

    @Test
    void 볼() {
        assertThat(balls.compare(new BallNumber(4), 1)).isEqualTo(BallStatus.BALL);
        assertThat(balls.compare(new BallNumber(4), 2)).isEqualTo(BallStatus.BALL);
        assertThat(balls.compare(new BallNumber(3), 0)).isEqualTo(BallStatus.BALL);
        assertThat(balls.compare(new BallNumber(3), 2)).isEqualTo(BallStatus.BALL);
        assertThat(balls.compare(new BallNumber(7), 0)).isEqualTo(BallStatus.BALL);
        assertThat(balls.compare(new BallNumber(7), 1)).isEqualTo(BallStatus.BALL);
    }

    @Test
    void 스트라이크() {
        assertThat(balls.compare(new BallNumber(4), 0)).isEqualTo(BallStatus.STRIKE);
        assertThat(balls.compare(new BallNumber(3), 1)).isEqualTo(BallStatus.STRIKE);
        assertThat(balls.compare(new BallNumber(7), 2)).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void 낫싱() {
        assertThat(balls.compare(new BallNumber(2), 0)).isEqualTo(BallStatus.NOTHING);
        assertThat(balls.compare(new BallNumber(6), 1)).isEqualTo(BallStatus.NOTHING);
        assertThat(balls.compare(new BallNumber(1), 2)).isEqualTo(BallStatus.NOTHING);
    }
}
