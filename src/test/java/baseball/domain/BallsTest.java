package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallsTest {

    @DisplayName("3자리 1-9 사이의 숫자가 입력되면 Balls가 생성된다")
    @ParameterizedTest
    @ValueSource(strings = {"123", "542", "193"})
    void from(String givenValue) {
        assertDoesNotThrow(() -> Balls.from(givenValue));
    }

    @DisplayName("숫자가 아닌 문자, 3자리가 아닌 숫자, 중복된 숫자, 0을 포함한 숫자가 입력되면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"aㅇ1", "$", "", "1", "12", "112", "902"})
    void invalid_from(String givenValue) {
        assertThatThrownBy(() -> Balls.from(givenValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
