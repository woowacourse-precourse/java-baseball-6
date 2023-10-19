package baseball.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "!", "12A"})
    @DisplayName("플레이어의 숫자에 대한 입력이 숫자가 아니라면 예외가 발생한다.")
    void validateBallNumbers(String input) {
        assertThatThrownBy(() -> Validator.validateBallNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력 가능합니다.");
    }
}