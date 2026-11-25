package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseballNumberTest {

    @Test
    @DisplayName("서로 다른 1부터 9까지의 숫자 3자리는 허용한다.")
    void acceptValidInput() {
        assertThatCode(() -> new BaseballNumber("123"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("입력값이 3자리보다 짧으면 예외가 발생한다")
    void rejectShortInput() {
        assertInvalidInput("12");
    }

    @Test
    @DisplayName("입력값이 3자리보다 길면 예외가 발생한다")
    void rejectLongInput() {
        assertInvalidInput("1234");
    }

    @Test
    @DisplayName("0이 포함되면 예외가 발생한다")
    void rejectZero() {
        assertInvalidInput("012");
    }

    @Test
    @DisplayName("문자가 포함되면 예외가 발생한다")
    void rejectLetters() {
        assertInvalidInput("1a3");
    }

    @Test
    @DisplayName("공백이 포함되면 예외가 발생한다")
    void rejectWhitespace() {
        assertInvalidInput("1 3");
    }

    @Test
    @DisplayName("숫자가 중복되면 예외가 발생한다")
    void rejectDuplicateDigits() {
        assertInvalidInput("121");
    }

    @Test
    @DisplayName("입력값이 비어 있으면 예외가 발생한다.")
    void rejectEmptyInput() {
        assertInvalidInput("");
    }

    private void assertInvalidInput(String input) {
        assertThatThrownBy(() -> new BaseballNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
