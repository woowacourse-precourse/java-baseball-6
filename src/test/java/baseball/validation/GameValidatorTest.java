package baseball.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameValidatorTest {

    @Test
    @DisplayName("입력값이 숫자일 경우 예외를 발생시키지 않는다")
    void validatePassNumbersTest() {
        // given
        String input = "123";

        // then
        assertThatCode(() -> GameValidator.validateIsNumber(input))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("입력값이 숫자가 아닐 경우 예외를 발생시킨다.")
    void ThrowIfNotNumbersTest() {
        // given
        String input = "abc";

        // then
        assertThatThrownBy(() -> GameValidator.validateIsNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력 가능합니다.");
    }

    @Test
    @DisplayName("입력값에 공백이 있을 경우 예외를 발생시킨다.")
    void blankThrowTest() {
        // given
        String input = "1 3";

        // then
        assertThatThrownBy(() -> GameValidator.validateIsNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력 가능합니다.");
    }

    @Test
    @DisplayName("입력값에 특수문자가 있을 경우 예외를 발생시킨다.")
    void specialLettersThrowTest() {
        // given
        String input = "!13";

        // then
        assertThatThrownBy(() -> GameValidator.validateIsNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력 가능합니다.");
    }

    @Test
    @DisplayName("입력값의 길이가 3일 경우 예외를 발생시키지 않는다")
    void validatePassIsLengthThreeTest() {
        // given
        String[] input = {"1", "2", "3"};

        // then
        assertThatCode(() -> GameValidator.validateIsThreeNumbers(input))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("입력값의 길이가 3이 아닐 경우 예외를 발생시킨다.")
    void numbersLengthNotThreeTest() {
        // given
        String[] input = {"1", "2"};

        // then
        assertThatThrownBy(() -> GameValidator.validateIsThreeNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 3자리 숫자만 입력 가능합니다.");
    }

    @Test
    @DisplayName("입력값이 1 또는 2일 경우 예외를 발생시키지 않는다")
    void validatePassIsOneOrTwoTest() {
        // given
        int input = 1;

        // then
        assertThatCode(() -> GameValidator.validateIsOneOrTwo(input))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("입력값이 1 또는 2가 아닐 경우 예외를 발생시킨다.")
    void numbersNotMatchTest() {
        // given
        int input = 3;

        // then
        assertThatThrownBy(() -> GameValidator.validateIsOneOrTwo(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1 또는 2만 입력 가능합니다.");
    }
}
