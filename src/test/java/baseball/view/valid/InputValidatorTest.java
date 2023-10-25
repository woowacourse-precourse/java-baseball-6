package baseball.view.valid;

import static baseball.view.valid.InputValidator.CONTAINS_ZERO_ERROR_MESSAGE;
import static baseball.view.valid.InputValidator.DUPLICATE_NUMBER_ERROR_MESSAGE;
import static baseball.view.valid.InputValidator.NOT_INT_ERROR_MESSAGE;
import static baseball.view.valid.InputValidator.NOT_THREE_DIGIT_ERROR_MESSAGE;
import static baseball.view.valid.InputValidator.RESTART_OR_EXIT_ERROR_MESSAGE;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {
    @ParameterizedTest
    @DisplayName("숫자가 아닌 값은 입력할 수 없습니다")
    @ValueSource(strings = {"suchan", "*&1", "12suchan", " "})
    void inputErrorWithNotNumber(String given) {
        // given
        InputValidator validator = new InputValidator();

        // when // then
        Assertions.assertThatThrownBy(() -> validator.validTryNumber(given))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_INT_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @DisplayName("숫자에 0이 존재하면 안됩니다")
    @ValueSource(strings = {"012", "000", "103", "130"})
    void inputErrorWithZero(String given) {
        // given
        InputValidator validator = new InputValidator();

        // when // then
        Assertions.assertThatThrownBy(() -> validator.validTryNumber(given))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(CONTAINS_ZERO_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @DisplayName("자릿수가 3자리 초과거나 미만은 입력할 수 없습니다.")
    @ValueSource(strings = {"1234", "1", "54", "1532"})
    void inputErrorOver3DigitOrLess(String given) {
        // given
        InputValidator validator = new InputValidator();

        // when // then
        Assertions.assertThatThrownBy(() -> validator.validTryNumber(given))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_THREE_DIGIT_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @DisplayName("중복이 있는 세자리수는 입력할 수 없습니다")
    @ValueSource(strings = {"122", "555", "121", "991"})
    void inputErrorWithDuplication(String given) {
        // given
        InputValidator validator = new InputValidator();

        // when // then
        Assertions.assertThatThrownBy(() -> validator.validTryNumber(given))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_NUMBER_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @DisplayName("재시작/종료를 위해서는 1과 2만 입력할 수 있습니다.")
    @ValueSource(strings = {"3", "0", "12", "991"})
    void validRestartOrExit(String given) {
        // given
        InputValidator validator = new InputValidator();

        // when // then
        Assertions.assertThatThrownBy(() -> validator.validRestartOrExit(given))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(RESTART_OR_EXIT_ERROR_MESSAGE);
    }
}