package baseball.view;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    void 플레이어가_숫자_이외의_문자를_입력하면_예외_발생() {
        String input = "12a";
        assertThatThrownBy(
                () -> InputValidator.validateNumericInput(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 플레이어가_숫자_문자를_입력하면_통과() {
        String input = "157";
        assertThatNoException().isThrownBy(
                () -> InputValidator.validateNumericInput(input)
        );
    }

    @Test
    void 게임_재실행과_종료에_대한_입력값이_1_또는_2가_아니면_예외_발생() {
        String input = "x";
        assertThatThrownBy(
                () -> InputValidator.validateNumericInput(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임_재실행_입력값이_1이면_통과() {
        String input = "1";
        assertThatNoException().isThrownBy(
                () -> InputValidator.validateNumericInput(input)
        );
    }

    @Test
    void 게임_재실행_입력값이_2이면_통과() {
        String input = "2";
        assertThatNoException().isThrownBy(
                () -> InputValidator.validateNumericInput(input)
        );
    }

}
