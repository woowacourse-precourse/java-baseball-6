package baseball.util.converter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("[StringConverterTest]")
class InputStringConverterTest {

    @Test
    @DisplayName("문자열 입력 시 정수 하나로 변환하여 반환")
    void returnOneIntValueWhenInputString() {
        // given
        InputStringConverter stringConverter = new InputStringConverter();
        String input = "4";
        int expectedResult = 4;

        // when
        int result = stringConverter.toInt(input);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("문자열 입력 시 정수 리스트로 변환하여 반환")
    void returnIntListWhenInputString() {
        // given
        InputStringConverter stringConverter = new InputStringConverter();
        String input = "123";
        List<Integer> expectedResult = Arrays.asList(1, 2, 3);

        // when
        List<Integer> result = stringConverter.toIntList(input);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest(name = "[{index}] : {0}")
    @ValueSource(strings = {"e", "acs", ""})
    @DisplayName("toInt 메소드에 정수가 아닌 값이 들어왔을 경우 IllegalArgumentException발생")
    void toIntThrowsIllegalArgumentExceptionWhenInputIsNotIntValue(final String input) {
        // given
        final String ERROR_MESSAGE_NOT_INT = "입력값이 정수가 아닙니다.";
        InputStringConverter stringConverter = new InputStringConverter();

        // when, then
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> stringConverter.toInt(input));
        assertThat(e.getMessage()).isEqualTo(ERROR_MESSAGE_NOT_INT);
    }

    @ParameterizedTest(name = "[{index}] : {0}")
    @ValueSource(strings = {"e", "acs", ""})
    @DisplayName("toIntList 메소드에 정수가 아닌 값이 들어왔을 경우 IllegalArgumentException발생")
    void toIntListThrowsIllegalArgumentExceptionWhenInputIsNotIntValue(final String input) {
        // given
        final String ERROR_MESSAGE_NOT_INT = "입력값이 정수가 아닙니다.";
        InputStringConverter stringConverter = new InputStringConverter();

        // when, then
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> stringConverter.toIntList(input));
        assertThat(e.getMessage()).isEqualTo(ERROR_MESSAGE_NOT_INT);
    }
}