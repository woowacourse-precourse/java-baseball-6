package baseball.domain;

import static baseball.utils.ErrorMessage.NUMBERS_NOT_POSITIVE_INTEGER;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

    @ParameterizedTest
    @DisplayName("0보다 큰 정수가 아니거나 문자가 들어오면 예외가 발생한다.")
    @ValueSource(strings = {"1ab", "abc", "-392", "1 2 3"})
    void createNumbersByNotPositiveInteger(String input) {
        assertThatThrownBy(() -> new Player(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBERS_NOT_POSITIVE_INTEGER);
    }

}