package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class InputExceptionTest {

    @DisplayName("게임 중 사용자 입력값이 형식에 맞지않으면 예외가 발생한다.")
    @CsvSource({"1234", "12", "가나", "sdg", "1가3"})
    @ParameterizedTest
    void validGameInput(String input) {
        assertThatThrownBy(() -> InputException.validGameInput(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 중 사용자 입력값이 비어있으면 예외가 발생한다.")
    @Test
    void validGameInput() {
        assertThatThrownBy(() -> InputException.validGameInput(" "))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 종료 후 사용자 입력값이 형식에 맞지않으면 예외가 발생한다.")
    @CsvSource({"12", "가나", "sdg"})
    @ParameterizedTest
    void validRestartInput(String input) {
        assertThatThrownBy(() -> InputException.validRestartInput(input))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
