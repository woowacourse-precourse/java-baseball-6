package baseball.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationTest {

    @Test
    public void 중복된_숫자_입력시_예외_발생() {
        //given
        String inputNumber = "144";

        //then
        assertThatThrownBy(() -> Validation.validateSameNumber(inputNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 입력한_문자열에_문자가_포함되어_있으면_예외_발생() {
        //given
        String inputNumber = "14j";

        //then
        assertThatThrownBy(() -> Validation.validateThatInputIsNumeric(inputNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}