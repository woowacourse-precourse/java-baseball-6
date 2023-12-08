package baseball.domain;

import baseball.exception.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        assertThatThrownBy(() -> new Numbers(numbers))
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
        assertThatThrownBy(() -> new Numbers(numbers))
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
        assertThatThrownBy(() -> new Numbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(ErrorMessages.INVALID_NUMBER_ERROR));
    }

    @DisplayName("스트라이크 개수를 계산한다.")
    @ParameterizedTest
    @CsvSource(textBlock = """
            123, 923, 2
            123, 453, 1
            123, 123, 3
            """)
    void calculateStrikes(String computer, String player, int expectedStrikes) {
        // given
        List<Integer> numbers1 = Arrays.stream(computer.split(""))
                .map(Integer::parseInt)
                .toList();
        List<Integer> numbers2 = Arrays.stream(player.split(""))
                .map(Integer::parseInt)
                .toList();

        // when
        Numbers computerNumbers = new Numbers(numbers1);
        Numbers playerNumbers = new Numbers(numbers2);

        // then
        int strikes = computerNumbers.calculateStrikes(playerNumbers);
        assertThat(strikes).isEqualTo(expectedStrikes);
    }

    @DisplayName("볼 개수를 계산한다.")
    @ParameterizedTest
    @CsvSource(textBlock = """
            123, 412, 2
            123, 451, 1
            123, 231, 3
            """)
    void calculateBalls(String computer, String player, int expectedBalls) {
        // given
        List<Integer> numbers1 = Arrays.stream(computer.split(""))
                .map(Integer::parseInt)
                .toList();
        List<Integer> numbers2 = Arrays.stream(player.split(""))
                .map(Integer::parseInt)
                .toList();

        // when
        Numbers computerNumbers = new Numbers(numbers1);
        Numbers playerNumbers = new Numbers(numbers2);

        // then
        int balls = computerNumbers.calculateBalls(playerNumbers);
        assertThat(balls).isEqualTo(expectedBalls);
    }
}