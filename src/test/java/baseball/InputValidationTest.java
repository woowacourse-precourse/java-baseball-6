package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.validation.InputValidation;
import org.junit.jupiter.api.Test;

class InputValidationTest {
    @Test
    void 입력된_값이_3자리가_맞는지_테스트() {
        assertThatThrownBy(() -> InputValidation.numbers("12"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> InputValidation.numbers("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력된_값이_숫자인지_테스트() {
        assertThatThrownBy(() -> InputValidation.numbers("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력된_값이_중복되지_않는지_테스트() {
        assertThatThrownBy(() -> InputValidation.numbers("112"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력된_값이_0이_포함되지_않는지_테스트() {
        assertThatThrownBy(() -> InputValidation.numbers("102"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 게임_종료_여부_입력값_테스트() {
        assertThatThrownBy(() -> InputValidation.endCommand("3"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> InputValidation.endCommand("22"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}