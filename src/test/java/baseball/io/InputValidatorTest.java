package baseball.io;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("입력값 검증 클래스의 객체에")
class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @Nested
    @DisplayName("숫자 검증을 요청시")
    class ValidateNumber {

        @Test
        @DisplayName("숫자로 이뤄진 입력값인 경우 예외를 던지지 않는다")
        void number() {
            // given
            final String input = "123";

            // when
            // then
            assertDoesNotThrow(() -> inputValidator.validateNumber(input));
        }

        @Test
        @DisplayName("숫자가 아닌 값이 포함된 입력값인 경우 예외를 던진다")
        void notNumber() {
            // given
            final String input = "1b3";

            // when
            // then
            assertThatThrownBy(() -> inputValidator.validateNumber(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("재시도 입력값 검증 요청시")
    class ValidateRetryCommand {

        @Test
        @DisplayName("길이가 1이 아닌 입력값인 경우 예외를 던진다")
        void longLength() {
            // given
            final String input = "12";

            // when
            // then
            assertThatThrownBy(() -> inputValidator.validateRetryCommand(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("숫자가 아닌 입력값인 경우 예외를 던진다")
        void notNumber() {
            // given
            final String input = "a";

            // when
            // then
            assertThatThrownBy(() -> inputValidator.validateRetryCommand(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
