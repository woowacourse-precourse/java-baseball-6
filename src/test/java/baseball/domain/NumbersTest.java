package baseball.domain;

import baseball.exception.ErrorMessages;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

@DisplayName("숫자 테스트")
class NumbersTest {

    @DisplayName("숫자가 중복된 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"111", "122", "332"})
    void duplicateNumbers(String input) {
        // given
        List<Integer> numbers = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .toList();

        // when & then
        Assertions.assertThatThrownBy(() -> new Numbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.DUPLICATE_NUMBERS_ERROR);
    }

    @DisplayName("숫자를 3개 입력하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"12", "1234", "1"})
    void invalidSize(String input) {
        // given
        List<Integer> numbers = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .toList();

        // when & then
        Assertions.assertThatThrownBy(() -> new Numbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(ErrorMessages.INVALID_SIZE_ERROR, Numbers.SIZE));
    }

    @DisplayName("유효하지 않은 수를 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"012"})
    void invalidNumber(String input) {
        // given
        List<Integer> numbers = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .toList();

        // when & then
        Assertions.assertThatThrownBy(() -> new Numbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(ErrorMessages.INVALID_NUMBER_ERROR));
    }
}