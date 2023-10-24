package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumbersTest {
    @Test
    @DisplayName("첫번째 숫자가 반환된다.")
    public void 첫번째_숫자가_반환된다() {
        // given
        Numbers numbers = new Numbers();
        numbers.addNumber(new Number(1));
        numbers.addNumber(new Number(2));
        numbers.addNumber(new Number(3));

        // when
        int firstDigit = numbers.getFirstDigit();

        // then
        assertThat(firstDigit).isEqualTo(1);
    }

    @Test
    @DisplayName("두번째 숫자가 반환된다.")
    public void 두번째_숫자가_반환된다() {
        // given
        Numbers numbers = new Numbers();
        numbers.addNumber(new Number(1));
        numbers.addNumber(new Number(2));
        numbers.addNumber(new Number(3));

        // when
        int secondDigit = numbers.getSecondDigit();

        // then
        assertThat(secondDigit).isEqualTo(2);
    }

    @Test
    @DisplayName("세번째 숫자가 반환된다.")
    public void 세번째_숫자가_반환된다() {
        // given
        Numbers numbers = new Numbers();
        numbers.addNumber(new Number(1));
        numbers.addNumber(new Number(2));
        numbers.addNumber(new Number(3));

        // when
        int thirdDigit = numbers.getThirdDigit();

        // then
        assertThat(thirdDigit).isEqualTo(3);
    }
}
