package baseball.domain;

import static baseball.domain.BallStatus.BALL;
import static baseball.domain.BallStatus.NOTHING;
import static baseball.domain.BallStatus.STRIKE;
import static baseball.domain.ErrorCode.INVALID_BALL_SIZE;
import static baseball.domain.ErrorCode.NOT_OTHER_NUMBERS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource(value = {"4,1", "4,2", "3,0", "3,2", "7,0", "7,1"})
    void 볼_검증(int number, int position) {
        // when
        BallStatus result = balls.compare(new BallNumber(number), position);

        // then
        assertThat(result).isEqualTo(BALL);
    }

    @ParameterizedTest
    @CsvSource(value = {"4,0", "3,1", "7,2"})
    void 스트라이크_검증(int number, int position) {
        // when
        BallStatus result = balls.compare(new BallNumber(number), position);

        // then
        assertThat(result).isEqualTo(STRIKE);
    }

    @ParameterizedTest
    @CsvSource(value = {"2,0", "6,1", "1,2"})
    void 낫싱_검증(int number, int position) {
        // when
        BallStatus result = balls.compare(new BallNumber(number), position);

        // then
        assertThat(result).isEqualTo(NOTHING);
    }
}
