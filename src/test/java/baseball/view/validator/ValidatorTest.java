package baseball.view.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ValidatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력이 null 이거나 공백이면 예외가 발생한다.")
    void validateInput(String input) {
        assertThatThrownBy(() -> Validator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력은 공백일 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "!", "12A"})
    @DisplayName("플레이어의 숫자에 대한 입력이 숫자가 아니라면 예외가 발생한다.")
    void validateBallNumbers(String input) {
        assertThatThrownBy(() -> Validator.validateBallNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"11", "22", "12", "a", "!"})
    @DisplayName("게임 재시작/종료 여부에 대한 입력이 1 또는 2가 아니라면 예외가 발생한다.")
    void validateRestartOptionNumber(String input) {
        assertThatThrownBy(() -> Validator.validateRestartOptionNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임 재시작/종료 여부에 대한 입력은 1 또는 2로만 가능합니다.");
    }
}