package baseball.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static baseball.constant.ErrorMessage.BASEBALL_NUMBERS_INPUT_EXCEPTION;
import static baseball.constant.ErrorMessage.CHOICE_NUMBER_INPUT_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputFormatValidatorTest {

    @DisplayName("유효하지 않은 형식의 숫자를 입력하면 IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @CsvSource({"12", "1234", "abc", "가나다"})
    void validateBaseballNumbers(String inputNumbers) {
        // given, when, then
        assertThatThrownBy(() -> InputFormatValidator.validateBaseballNumbers(inputNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BASEBALL_NUMBERS_INPUT_EXCEPTION);
    }

    @DisplayName("1 또는 2가 아닌 다른 숫자를 입력하면 IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @CsvSource({"0", "3", "abc", "가나다"})
    void validateChoiceNumber(String choiceOfRestart) {
        // given, when, then
        assertThatThrownBy(() -> InputFormatValidator.validateChoiceNumber(choiceOfRestart))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CHOICE_NUMBER_INPUT_EXCEPTION);
    }

}
