package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberTest {
    @Test
    @DisplayName("첫번째 숫자가 반환된다.")
    public void 첫번째_숫자가_반환된다() {
        // given
        Number number = new Number(123);

        // when
        int firstDigit = number.getFirstDigit();

        // then
        assertThat(firstDigit).isEqualTo(1);
    }

    @Test
    @DisplayName("두번째 숫자가 반환된다.")
    public void 두번째_숫자가_반환된다() {
        // given
        Number number = new Number(123);

        // when
        int secondDigit = number.getSecondDigit();

        // then
        assertThat(secondDigit).isEqualTo(1);
    }

    @Test
    @DisplayName("세번째 숫자가 반환된다.")
    public void 세번째_숫자가_반환된다() {
        // given
        Number number = new Number(123);

        // when
        int thirdDigit = number.getThirdDigit();

        // then
        assertThat(thirdDigit).isEqualTo(2);
    }
}
