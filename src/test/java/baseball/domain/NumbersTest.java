package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumbersTest {

    @Test
    void 숫자열이_생성된다() {
        String input = "123";

        Numbers numbers = new Numbers(input);

        Assertions.assertTrue(numbers.hasNumber(new Number(1)));
        Assertions.assertFalse(numbers.hasNumber(new Number(4)));
    }

    @Test
    void 숫자의_개수가_3개초과시_예외가_발생한다() {
        String input = "1234";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Numbers(input));
    }

    @Test
    void 문자열_입력시_예외가_발생한다() {
        String input = "ab34";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Numbers(input));
    }
}
