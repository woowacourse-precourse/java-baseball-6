package baseball.domain.util.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    @Nested
    class 성공 {
        @Test
        void checkBaseballNumberSize() {
            assertDoesNotThrow(() -> InputValidator.checkBaseballNumberSize("123"));
        }

        @Test
        void checkBetweenMinAndMax() {
            assertDoesNotThrow(() -> InputValidator.checkBetweenMinAndMax("123"));
        }

        @Test
        void checkDuplicationNumber() {
            assertDoesNotThrow(() -> InputValidator.checkDuplicationNumber("123"));
        }

        @Test
        void isNumber() {
            assertDoesNotThrow(() -> InputValidator.isNumber("1"));
            assertDoesNotThrow(() -> InputValidator.isNumber("123"));
        }
    }

    @Nested
    class 예외_발생 {
        @Test
        void checkBaseballNumberSize_3() {
            exception_generator("12", () -> InputValidator.checkBaseballNumberSize("12"), "3개의 숫자를 입력해야 합니다.");
            exception_generator("1234", () -> InputValidator.checkBaseballNumberSize("1234"), "3개의 숫자를 입력해야 합니다.");
        }

        @Test
        void checkBetweenMinAndMax_1_to_9() {
            exception_generator("120", () -> InputValidator.checkBetweenMinAndMax("120"), "1~9 사이의 숫자만 가능합니다.");
            exception_generator("1290", () -> InputValidator.checkBetweenMinAndMax("1290"), "1~9 사이의 숫자만 가능합니다.");
        }

        @Test
        void checkDuplicationNumber() {
            exception_generator("112", () -> InputValidator.checkDuplicationNumber("112"), "입력된 숫자에 중복된 값이 있습니다.");
        }

        @Test
        void isNumber() {
            exception_generator("12a", () -> InputValidator.isNumber("12a"), "숫자를 입력해야 합니다.");
        }

        private static void exception_generator(String input, ThrowingCallable validatorMethod,
                                                String expectedMessage) {
            assertThatThrownBy(validatorMethod)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(expectedMessage);
        }
    }
}
