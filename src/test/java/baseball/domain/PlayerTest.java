package baseball.domain;

import static baseball.utils.ErrorMessage.NUMBERS_NOT_POSITIVE_INTEGER;
import static baseball.utils.ErrorMessage.NUMBERS_SIZE_IS_INVALID;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {
    private static final int MIN = 3;
    private static final int MAX = 20;

    @ParameterizedTest
    @DisplayName("숫자의 길이가 3이 아니면 예외가 발생한다.")
    @ValueSource(strings = {"1234", "93", ""})
    void createNumbersSizeByOutOfRange(String input) {
        assertThatThrownBy(() -> new Player().validateSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBERS_SIZE_IS_INVALID);
    }

    @ParameterizedTest
    @DisplayName("0보다 큰 정수가 아니거나 문자가 들어오면 예외가 발생한다.")
    @ValueSource(strings = {"1ab", "abc", "-392", "1 2 3"})
    void createNumbersByNotPositiveInteger(String input) {
        assertThatThrownBy(() -> new Player().validatePositiveInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBERS_NOT_POSITIVE_INTEGER);
    }


}

// NUMBERS_SIZE_IS_INVALID