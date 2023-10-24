package baseball.io.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static baseball.exception.ExceptionMessage.InputException.INPUT_MUST_BE_NUMERIC;
import static baseball.exception.ExceptionMessage.InputException.INPUT_MUST_NOT_CONTAINS_SPACE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BaseballInputValidatorTest {
    private final BaseballInputValidator sut = new BaseballInputValidator();

    @Test
    @DisplayName("Baseball 입력에 공백이 존재하면 예외가 발생한다")
    void throwExceptionByInputHasSpace() {
        assertThatThrownBy(() -> sut.validate("123 "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_MUST_NOT_CONTAINS_SPACE.message);
    }

    @Test
    @DisplayName("Baseball이 숫자가 아니면 예외가 발생한다")
    void throwExceptionByInputIsNotNumeric() {
        assertThatThrownBy(() -> sut.validate("12a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_MUST_BE_NUMERIC.message);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "129", "345"})
    @DisplayName("Baseball 검증에 성공한다")
    void success(final String userInput) {
        assertDoesNotThrow(() -> sut.validate(userInput));
    }
}
