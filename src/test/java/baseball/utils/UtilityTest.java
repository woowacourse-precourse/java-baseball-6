package baseball.utils;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class UtilityTest {

    @Test
    void 양의_일의자리_정수를_입력하면_예외가_발생하지_않음() {
        // given
        String input = "123456789";

        // when, then
        assertThatCode(() -> Utility.checkIfIsPositiveDigitInteger(input))
            .doesNotThrowAnyException();;
    }

    @Test
    void 정수가_아니면_예외가_발생함() {
        // given
        String input = "012";

        // when, then
        assertThatThrownBy(() -> Utility.checkIfIsPositiveDigitInteger(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력 값은 양의 일의자리 정수이어야 합니다.");
    }


    @Test
    void 서로_다른_숫자를_입력하면_예외가_발생하지_않음() {
        // given
        String input = "123456789";

        // when, then
        assertThatCode(() -> Utility.checkIfIsDifferent(input))
            .doesNotThrowAnyException();;
    }

    @Test
    void 중복_숫자를_입력하면_예외가_발생함() {
        // given
        String input = "111";

        // when, then
        assertThatThrownBy(() -> Utility.checkIfIsDifferent(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("서로 다른 숫자를 입력해야 합니다.");
    }

    @Test
    void 게임의_룰에_맞게_공의_개수를_입력하면_예외가_발생하지_않음() {
        // given
        String input = "123";
        int numberBalls = 3;

        // when, then
        assertThatCode(() -> Utility.checkIfIsValidLength(numberBalls, input))
            .doesNotThrowAnyException();;
    }

    @Test
    void 게임의_룰에_맞지않는_공의_개수를_입력하면_예외가_발생함() {
        // given
        String input = "1234";
        int numberBalls = 3;

        // when, then
        assertThatThrownBy(() -> Utility.checkIfIsValidLength(numberBalls, input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("공의 개수는 " + numberBalls + "개를 입력해야 합니다.");
    }

}