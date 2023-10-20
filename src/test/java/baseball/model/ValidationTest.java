package baseball.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationTest {

    @Test
    public void 중복된_숫자_입력시_예외_발생() {
        //given
        String inputNumber = "144";

        //when
        assertThatThrownBy(() -> Validation.validateSameNumber(inputNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}