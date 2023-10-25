package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void 숫자_1_9_검증_실패(int number) {
        // when
        // then
        Assertions.assertThatThrownBy(() -> new BallNumber(number))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorCode.NOT_SINGLE_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 9})
    void 숫자_1_9_검증_성공(int number) {
        // when
        BallNumber result = new BallNumber(number);

        // then
        assertThat(result).isNotNull();
    }
}
