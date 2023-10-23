package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BallTest {
    @DisplayName("Ball 생성")
    @Nested()
    class CreateBall {
        @DisplayName("유효한 숫자와 포지션을 입력하면 예외가 발생하지 않는다")
        @ParameterizedTest
        @CsvSource({"1, 0", "9, 3"})
        void noExceptionIfValidNumberAndPosition(int validNumber, int validPosition) {
            assertThatNoException()
                    .isThrownBy(() -> new Ball(validNumber, validPosition));
        }

        @DisplayName("유효하지 않은 숫자를 입력하면 예외가 발생한다")
        @ParameterizedTest
        @CsvSource({"-1, 0", "0, 0", "10, 0"})
        void throwExceptionIfInvalidNumber(int invalidNumber, int validPosition) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Ball(invalidNumber, validPosition));
        }

        @DisplayName("유효하지 않은 포지션을 입력하면 예외가 발생한다")
        @ParameterizedTest
        @CsvSource({"1, -1", "1, 4"})
        void throwExceptionIfInvalidPosition(int validNumber, int invalidPosition) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Ball(validNumber, invalidPosition));
        }
    }
}
