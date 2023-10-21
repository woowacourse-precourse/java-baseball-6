package baseball.util;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {

    @Nested
    class invalidInputTest {

        @ParameterizedTest
        @ValueSource(strings = {"abc", "012", "ab1", "12a"})
        public void 입력값이_1부터_9까지로_이루어져_있나_검증(String input) {
            assertThatThrownBy(() -> Validator.getValidatedPlayerNumber(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.NOT_IN_RANGE.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1234", "12"})
        public void 입력값의_길이가_3인지_검증(String input) {
            assertThatThrownBy(() -> Validator.getValidatedPlayerNumber(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_LENGTH.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"332", "133"})
        public void 입력값에_중복이_존재하는지_검증(String input) {
            assertThatThrownBy(() -> Validator.getValidatedPlayerNumber(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.DUPLICATED_NUMBER.getMessage());
        }
    }

    @Nested
    class validInputTest {
        @ParameterizedTest
        @ValueSource(strings = {"123", "456", "135", "789"})
        public void 정상_입력_검증(String input) {
            assertThatCode(() -> Validator.getValidatedPlayerNumber(input))
                    .doesNotThrowAnyException();
        }
    }

}
