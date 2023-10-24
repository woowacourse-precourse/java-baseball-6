package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BallNumberTest {

    @Test
    void 숫자_1_9_검증_0_실패() {
        // given
        int number = 0;

        // when
        // then
        Assertions.assertThatThrownBy(() -> new BallNumber(number))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorCode.NOT_SINGLE_NUMBER.getMessage());
    }

    @Test
    void 숫자_1_9_검증_10_실패() {
        // given
        int number = 0;

        // when
        // then
        Assertions.assertThatThrownBy(() -> new BallNumber(number))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorCode.NOT_SINGLE_NUMBER.getMessage());
    }

    @Test
    void 숫자_1_9_검증_1_성공() {
        // given
        int number = 1;

        // when
        BallNumber result = new BallNumber(number);

        // then
        assertThat(result).isNotNull();
    }

    @Test
    void 숫자_1_9_검증_9_성공() {
        // given
        int number = 9;

        // when
        BallNumber result = new BallNumber(number);

        // then
        assertThat(result).isNotNull();
    }
}
