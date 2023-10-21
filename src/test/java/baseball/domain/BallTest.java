package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallTest {
    @DisplayName("Ball 생성")
    @Nested()
    class CreateBall {
        @DisplayName("유효한 숫자를 입력하면 예외가 발생하지 않는다")
        @ParameterizedTest
        @ValueSource(ints = {1, 9})
        void noExceptionIfValidNumber(int validNumber) {
            assertThatNoException()
                    .isThrownBy(() -> new Ball(validNumber));
        }

        @DisplayName("유효하지 않은 숫자를 입력하면 예외가 발생한다")
        @ParameterizedTest
        @ValueSource(ints = {-1, 0, 10})
        void throwExceptionIfInvalidNumber(int invalidNumber) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Ball(invalidNumber));
        }
    }
}
