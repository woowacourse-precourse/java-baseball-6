package baseball.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.common.config.BaseballSystemConst;
import baseball.common.utils.NumberGenerator;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

    @Test
    void 사이즈가_MAX_BALL_SIZE_인지_검사() {
        List<Integer> numbers = NumberGenerator.makeRandomNumber();
        assertEquals(BaseballSystemConst.MAX_BALL_SIZE, numbers.size());
    }

    @Test
    void 중복된_숫자가_없는지_검사() {
        List<Integer> numbers = NumberGenerator.makeRandomNumber();
        HashSet<Integer> distinctNumbers = new HashSet<>(numbers);
        assertEquals(distinctNumbers.size(), numbers.size());
    }

    @Test
    void 숫자_범위가_MIN_DIGIT_BALL_부터_MAX_DIGIT_BALL_인지_검사() {
        List<Integer> numbers = NumberGenerator.makeRandomNumber();
        for (int number : numbers) {
            assertTrue(number >= BaseballSystemConst.MIN_DIGIT_BALL && number <= BaseballSystemConst.MAX_DIGIT_BALL);
        }
    }
}