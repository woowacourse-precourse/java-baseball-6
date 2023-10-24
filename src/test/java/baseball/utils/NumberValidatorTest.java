package baseball.utils;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.common.config.BaseballMessageConst;
import baseball.common.utils.NumberValidator;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class NumberValidatorTest {

    @Test
    void 사이즈가_3이_아닌_경우_IllegalArgumentException() {
        List<Integer> numbers = Arrays.asList(1, 2);
        assertThrows(IllegalArgumentException.class, () -> NumberValidator.isValid(numbers),
                BaseballMessageConst.INVALID_BALL_COUNT_ERROR);
    }

    @Test
    void 중복된_숫자가_있는_경우_IllegalArgumentException() {
        List<Integer> numbers = Arrays.asList(1, 2, 2);
        assertThrows(IllegalArgumentException.class, () -> NumberValidator.isValid(numbers),
                BaseballMessageConst.EXIST_BALL_ERROR);
    }

    @Test
    void 정상적으로_수행되는_경우() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        assertDoesNotThrow(() -> NumberValidator.isValid(numbers));
    }

}