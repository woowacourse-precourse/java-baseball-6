package baseball.view;

import baseball.util.ExceptionMessage;
import baseball.util.Validation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {
    @ParameterizedTest
    @DisplayName("빈값 입력 예외 테스트")
    @ValueSource(strings = {"", " ", "  ", "   "})
    void invalidInputsTest1(String input) {
        Assertions.assertThatThrownBy(() -> Validation.isEmpty(input)).
                isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INPUT_VALUE);
    }

    @ParameterizedTest
    @DisplayName("세 자리 숫자 입력 미준수 예외 테스트")
    @ValueSource(strings = {"", "1", "12", "1234", "abc99"})
    void invalidInputsTest2(String input) {
        Assertions.assertThatThrownBy(() -> Validation.isLengthThree(input)).
                isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INPUT_THREE_DIGIT_NUMBER);
    }

    @ParameterizedTest
    @DisplayName("1부터 9까지 숫자외 입력 예외 테스트")
    @ValueSource(strings = {"-132", "000", "!@$", "pg9", "909", "007", "-23"})
    void invalidInputsTest3(String input) {
        Assertions.assertThatThrownBy(() -> Validation.isInRange(input)).
                isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INPUT_NON_ZERO_SINGLE_DIGIT);
    }

    @ParameterizedTest
    @DisplayName("중복된 숫자 입력 예외 테스트")
    @ValueSource(strings = {"113", "155", "383", "999", "464"})
    void invalidInputsTest4(String input) {
        Assertions.assertThatThrownBy(() -> Validation.isDuplicate(input)).
                isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INPUT_DISTINCT_NUMBERS);
    }

    @ParameterizedTest
    @DisplayName("모든 유효성 성공 테스트")
    @ValueSource(strings = {"123", "456", "789", "245", "386"})
    void validInputsTest(String input) {
        Assertions.assertThatCode(() -> Validation.isValidInput(input))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("1 혹은 2의 숫자외 입력 예외 테스트")
    @ValueSource(strings = {"0", "11", "22", "-1", "111", "12", "222"})
    void invalidInputsTest5(String input) {
        Assertions.assertThatThrownBy(() -> Validation.isRestartInputInRange(input)).
                isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INPUT_ONE_OR_TWO);
    }

    @ParameterizedTest
    @DisplayName("재시작 여부 입력 모든 유효성 성공 테스트")
    @ValueSource(strings = {"1", "2"})
    void validInputsTest2(String input) {
        Assertions.assertThatCode(() -> Validation.isValidRestartInput(input))
                .doesNotThrowAnyException();
    }
}