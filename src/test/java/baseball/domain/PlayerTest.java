package baseball.domain;

import static baseball.utils.ErrorMessage.NUMBERS_DUPLICATED;
import static baseball.utils.ErrorMessage.NUMBERS_NOT_POSITIVE_INTEGER;
import static baseball.utils.ErrorMessage.NUMBERS_OUT_OF_RANGE;
import static baseball.utils.ErrorMessage.NUMBERS_SIZE_IS_INVALID;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {
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

    @ParameterizedTest
    @DisplayName("각 자릿수가 1~9 범위를 벗어난 경우 예외가 발생한다.")
    @ValueSource(strings = {"012", "302", "450"})
    void createNumbersByOutOfRange(String input) {
        assertThatThrownBy(() -> new Player().validateRange(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBERS_OUT_OF_RANGE);
    }

    @ParameterizedTest
    @DisplayName("중복된 수가 있는 경우 예외가 발생한다.")
    @ValueSource(strings = {"122", "434", "555"})
    void createNumbersByDuplicatedNumbers(String input) {
        assertThatThrownBy(() -> new Player().validateDuplicatedNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBERS_DUPLICATED);
    }

}