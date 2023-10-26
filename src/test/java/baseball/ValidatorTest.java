package baseball;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import baseball.util.ExceptionMessage;
import baseball.util.validation.Validator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {

    @Nested
    class invalidInput {

        @ParameterizedTest
        @ValueSource(strings = {"3333333333333333333333333333", "4444444444444444444444444444"})
        void int_범위_초과_입력(String input) {
            assertThatThrownBy(() -> Validator.getValidatedPlayerNumber(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.NOT_IN_RANGE.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"130", "000", "104"})
        void 범위를_초과한_숫자_입력(String input) {
            assertThatThrownBy(() -> Validator.getValidatedPlayerNumber(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.NOT_NUMERIC.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"123124", "12", "2134"})
        void 세자리가_아닌_숫자_입력(String input) {
            assertThatThrownBy(() -> Validator.getValidatedPlayerNumber(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_LENGTH.getMessage());
        }

        @Nested
        class validInputTest {
            @ParameterizedTest
            @ValueSource(strings = {"156", "367", "421", "111"})
            void 정상_입력(String input) {
                assertThatCode(() -> Validator.getValidatedPlayerNumber(input))
                        .doesNotThrowAnyException();
            }
        }
    }
}
