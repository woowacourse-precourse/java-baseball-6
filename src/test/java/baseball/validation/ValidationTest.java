package baseball.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class ValidationTest {

    @Test
    void 입력값_문자_예외_테스트() {
        // given
        String input = "1a3";

        // then
        assertThatThrownBy(() -> NumberFormatValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값_범위_예외_테스트() {
        // given
        String input = "109";

        // then
        assertThatThrownBy(() -> NumberRangeValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값_길이_예외_테스트() {
        // given
        String input = "1234";

        // then
        assertThatThrownBy(() -> NumberSizeValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값_중복_예외_테스트() {
        // given
        String input = "737";

        // then
        assertThatThrownBy(() -> NumberDuplicateValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
