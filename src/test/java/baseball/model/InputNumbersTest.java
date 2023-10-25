package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static baseball.exception.ErrorMessage.INVALID_BALL_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputNumbersTest {

    @DisplayName("1-9로 이루어진 중복없는 3자리 수를 입력받기.")
    @ParameterizedTest
    @ValueSource(strings = {"123", "258", "654", "987"})
    public void get_input_three_numbers(String threeNumbers) throws Exception {
        //given, when
        InputNumbers inputNumbers = new InputNumbers(threeNumbers);

        //then
        assertThat(inputNumbers.value()).isEqualTo(threeNumbers);
    }

    @DisplayName("1-9로 이루어진 3자리 수를 입력받기 예외 : 공백이나 빈 문자열이 입력된 경우 IllegalArgumentException을 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    public void get_input_three_numbers_exception_space(String illegalFormat) throws Exception {
        //when, then
        assertThatThrownBy(() -> new InputNumbers(illegalFormat))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_BALL_NUMBER.toString());
    }

    @DisplayName("1-9로 이루어진 3자리 수를 입력받기 예외 : 숫자가 아닌 문자가 포함된 경우 IllegalArgumentException을 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"12마", "가나다", "abc", "13a"})
    public void get_input_three_numbers_exception_illegalFormat(String illegalFormatNumbers) throws Exception {
        //when, then
        assertThatThrownBy(() -> new InputNumbers(illegalFormatNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_BALL_NUMBER.toString());
    }

    @DisplayName("1-9로 이루어진 3자리 수를 입력받기 예외 : 숫자이지만 길이가 3이 아닌 경우 IllegalArgumentException을 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "1", "21", "12567"})
    public void get_input_three_numbers_exception_illegalLength(String illegalLengthNumbers) throws Exception {
        //when, then
        assertThatThrownBy(() -> new InputNumbers(illegalLengthNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_BALL_NUMBER.toString());
    }
}
