package baseball.util;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static baseball.util.ErrorMessage.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    void 사용자입력에_중복_숫자_예외테스트() {
        // given
        String number = "112";

        // when, then
        assertThatThrownBy(() -> InputValidator.validatePlayerNumberInput(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PLAYER_INPUT_NUMBER_DUPLICATE_NUMBER.message);
    }

    @Test
    void 사용자입력에_3자리가_아닌_숫자_예외테스트() {
        // given
        String number = "98";

        // when, then
        assertThatThrownBy(() -> InputValidator.validatePlayerNumberInput(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PLAYER_INPUT_NUMBER_NOT_3_DIGIT.message);
    }

    @Test
    void 사용자입력에_정해진_범위_위반_예외테스트() {
        // given
        String number = "208";

        // when, then
        assertThatThrownBy(() -> InputValidator.validatePlayerNumberInput(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PLAYER_INPUT_NUMBER_NOT_GIVEN_RANGE.message);
    }

    @Test
    void 사용자입력에_숫자가_아닌_예외테스트() {
        // given
        String number = "7@a";

        // when, then
        assertThatThrownBy(() -> InputValidator.validatePlayerNumberInput(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PLAYER_INPUT_NUMBER_NOT_GIVEN_RANGE.message);
    }

    @Test
    void 사용자입력_검증_성공_테스트() {
        // given
        String number = "651";

        // when, then
        assertDoesNotThrow(
                () -> InputValidator.validatePlayerNumberInput(number)
        );
    }

    @Test
    void 정수_리스트를_문자열로_변환_테스트() {
        // given
        List<Integer> numbers = Lists.list(4, 7, 5);

        // when
        String convertedStr = InputValidator.convertListToString(numbers);

        // then
        assertEquals("475", convertedStr);
    }
}